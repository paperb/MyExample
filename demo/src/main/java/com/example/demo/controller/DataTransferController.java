package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.SysLog;
import com.example.demo.entity.Client;
import com.example.demo.entity.FileChunkParam;
import com.example.demo.entity.WorkOrderInfo;
import com.example.demo.service.DataTransferService;
import com.example.demo.utils.MyFileUtils;
import com.example.demo.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@RestController
public class DataTransferController {

    private static final Logger logger = LoggerFactory.getLogger(DataTransferController.class);
    @Autowired
    DataTransferService dataTransferService;




    @PostMapping("/batchImportClient")
    public R batchUpload(@RequestParam("files")MultipartFile[] files){
        for (MultipartFile file : files) {
            if (file.getName().contains("elient.eslx")) {
                //dataTransferService.batchImport("",file);
            } else {
                dataTransferService.uploadFile(new WorkOrderInfo(), file);
            }
        }
        return null;
    }

    @SysLog
    @ApiOperation(value = "上传文件",notes = "上传工单的附件")
    @RequestMapping(value = "/uploadfiles",method = RequestMethod.POST)
    public R uploadFiles(@RequestParam(value = "entity") String entity,
            @RequestParam("file")MultipartFile multipartFile){

        WorkOrderInfo workOrderInfo = JSONObject.parseObject(entity,WorkOrderInfo.class);

        try {
            dataTransferService.uploadFile(workOrderInfo,multipartFile);
            logger.info("上传XX文件");
            logger.error("上传错误");
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }

    @SysLog
    @ApiOperation(value = "上传excel文件",notes = "导入excel文件到数据库")
    @PostMapping("/importclient")
    public R ExcelImport(@Valid FileChunkParam param, HttpServletRequest request){



        boolean a = false;


        //String fileName = file.getOriginalFilename();

//        try {
//            a = dataTransferService.batchImport(fileName, file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return R.ok();
    }


    @GetMapping("/exportclient")
    @ApiOperation(value = "导出客户excel", notes = "导出客户excel")
    public void exportUser()
            throws IOException {
        List<Client> middleList = new ArrayList<>();
        // 查询客户详细信息
            List<Client> clientList = dataTransferService.queryClientAll();

        // excel格式
        String[] headers = {"姓名", "手机号", "地址", "创建时间"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        // 设置列宽
        sheet.setDefaultColumnWidth((short)18);
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            // 创建单元格，每行多少数据就创建多少个单元格
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            // 给单元格设置内容
            cell.setCellValue(text);
        }
        for (int j = 0; j < clientList.size(); j++) {
            Client client = clientList.get(j);
            // 从第二行开始填充数据
            row = sheet.createRow(j + 1);
            List<String> datas = new ArrayList<>();

            String name = client.getName();
            String phone = client.getPhone();
            String address = client.getAddress();
            String creatTime = String.valueOf(client.getCreateTime());

            datas.add(name);
            datas.add(phone);
            datas.add(address);
            datas.add(creatTime);

            for (int k = 0; k < datas.size(); k++) {
                String string = datas.get(k);
                HSSFCell cell = row.createCell(k);
                HSSFRichTextString richString = new HSSFRichTextString(string);
                HSSFFont font3 = workbook.createFont();
                // 定义Excel数据颜色，这里设置为蓝色
                font3.setColor(HSSFColor.BLUE.index);
                richString.applyFont(font3);
                cell.setCellValue(richString);
            }
        }
        String fileName = "客户导出.xls";
        // 导出
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        RequestAttributes requsetAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requsetAttributes).getRequest();
        // 获得浏览器代理信息
        final String userAgent = request.getHeader("USER-AGENT");
        // 判断浏览器代理并分别设置响应给浏览器的编码格式
        if (StringUtils.contains(userAgent, "MSIE") || StringUtils.contains(userAgent, "Trident")) {
            // IE浏览器
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else if (StringUtils.contains(userAgent, "Mozilla")) {
            // google,火狐浏览器
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        } else {
            // 其他浏览器
            fileName = URLEncoder.encode(fileName, "UTF-8");// 其他浏览器
        }
        // 设置HTTP响应头
        response.reset();
        // 重置 如果不在页面上显示而是下载下来 则放开注释
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        OutputStream os = response.getOutputStream();
        workbook.write(os);
        os.close();
    }


    private String saveFile(MultipartFile multipartFile, HttpServletRequest request) {
        String path;
        String fileName = multipartFile.getOriginalFilename();
        // 判断文件类型
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String trueFileName = fileName;
        // 设置存放Excel文件的路径
        path = realPath + trueFileName;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        try {
            multipartFile.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
