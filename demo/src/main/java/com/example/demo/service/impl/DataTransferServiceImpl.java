package com.example.demo.service.impl;

import com.example.demo.dao.ExcelDao;
import com.example.demo.dao.FileDao;
import com.example.demo.entity.Client;
import com.example.demo.entity.WorkOrderInfo;
import com.example.demo.exception.MyException;
import com.example.demo.service.DataTransferService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.MyFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


@Slf4j
@Service
public class DataTransferServiceImpl implements DataTransferService {

    @Autowired
    FileDao fileDao;

    @Autowired
    ExcelDao excelDao;

    @Override
    public void uploadFile(WorkOrderInfo workOrderInfo, MultipartFile multipartFile) {

        MyFileUtils myFileUtils = new MyFileUtils();
        String storePath = null;
        try {
            storePath = myFileUtils.uploadFile(multipartFile);
            workOrderInfo.setStorePath(storePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        workOrderInfo.setCreateTime(new Date());

        fileDao.insertOneFile(workOrderInfo);

    }

    @Override
    public void truncateList() {
        fileDao.truncateList();
    }


    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<Client> clientList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        Client client;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null) {
                continue;
            }

            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException

            client = new Client();

            if (row.getCell(0).getCellType() != 1) {//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }

            String name = (row.getCell(0).getStringCellValue());//得到每一行第一个单元格的值


            if (name == null || name.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String phone = row.getCell(1).getStringCellValue();


            if (phone == null || phone.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,密码未填写)");
            }


            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String address = row.getCell(2).getStringCellValue();


            if (phone == null || phone.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,密码未填写)");
            }

            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第三个单元格的值
            String createTime = row.getCell(3).getStringCellValue();


            if (createTime == null || createTime.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,密码未填写)");
            }


            //完整的循环一次 就组成了一个对象
            client.setId(null);
            client.setName(name);
            client.setPhone(phone);
            client.setAddress(address);
            client.setCreateTime(DateUtils.parse(createTime));
            clientList.add(client);
        }
        for (Client client1 : clientList) {
            Date createTime = client1.getCreateTime();
            int cnt = fileDao.selectByCreateTime(createTime);
            if (cnt == 0) {
                fileDao.addClient(client1);
                log.info(" 插入 "+client1);
                //System.out.println(" 插入 " + client1);
            } else {

            }
        }
        return notNull;
    }

    @Override
    public List<Client> queryClientAll() {
        return excelDao.selectClientAll();
    }


}
