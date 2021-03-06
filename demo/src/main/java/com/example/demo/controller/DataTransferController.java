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
    @ApiOperation(value = "????????????",notes = "?????????????????????")
    @RequestMapping(value = "/uploadfiles",method = RequestMethod.POST)
    public R uploadFiles(@RequestParam(value = "entity") String entity,
            @RequestParam("file")MultipartFile multipartFile){

        WorkOrderInfo workOrderInfo = JSONObject.parseObject(entity,WorkOrderInfo.class);

        try {
            dataTransferService.uploadFile(workOrderInfo,multipartFile);
            logger.info("??????XX??????");
            logger.error("????????????");
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }

    @SysLog
    @ApiOperation(value = "??????excel??????",notes = "??????excel??????????????????")
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
    @ApiOperation(value = "????????????excel", notes = "????????????excel")
    public void exportUser()
            throws IOException {
        List<Client> middleList = new ArrayList<>();
        // ????????????????????????
            List<Client> clientList = dataTransferService.queryClientAll();

        // excel??????
        String[] headers = {"??????", "?????????", "??????", "????????????"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        // ????????????
        sheet.setDefaultColumnWidth((short)18);
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            // ???????????????????????????????????????????????????????????????
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            // ????????????????????????
            cell.setCellValue(text);
        }
        for (int j = 0; j < clientList.size(); j++) {
            Client client = clientList.get(j);
            // ??????????????????????????????
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
                // ??????Excel????????????????????????????????????
                font3.setColor(HSSFColor.BLUE.index);
                richString.applyFont(font3);
                cell.setCellValue(richString);
            }
        }
        String fileName = "????????????.xls";
        // ??????
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        RequestAttributes requsetAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requsetAttributes).getRequest();
        // ???????????????????????????
        final String userAgent = request.getHeader("USER-AGENT");
        // ?????????????????????????????????????????????????????????????????????
        if (StringUtils.contains(userAgent, "MSIE") || StringUtils.contains(userAgent, "Trident")) {
            // IE?????????
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else if (StringUtils.contains(userAgent, "Mozilla")) {
            // google,???????????????
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        } else {
            // ???????????????
            fileName = URLEncoder.encode(fileName, "UTF-8");// ???????????????
        }
        // ??????HTTP?????????
        response.reset();
        // ?????? ????????????????????????????????????????????? ???????????????
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        OutputStream os = response.getOutputStream();
        workbook.write(os);
        os.close();
    }


    private String saveFile(MultipartFile multipartFile, HttpServletRequest request) {
        String path;
        String fileName = multipartFile.getOriginalFilename();
        // ??????????????????
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String trueFileName = fileName;
        // ????????????Excel???????????????
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
