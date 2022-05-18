package com.example.demo.utils;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class MyFileUtils  {

@Autowired
FastFileStorageClient fastDFSClient;

    //public static FastFileStorageClient fastDFSClient1;
    private static MyFileUtils myFileUtils;

    public String uploadFile(MultipartFile multipartFile) throws IOException {

        String path = "demo/src/main/resources/files/file";
        File file = new File(path);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);

            StorePath storePath = myFileUtils.fastDFSClient.uploadFile(null, new FileInputStream(file), file.length(), file.getName());

        return String.valueOf(storePath.getFullPath());
    }

    private void downloadFile(){

    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//fastDFSClient1 = fastDFSClient;
//    }
    @PostConstruct
    public void init() {
        myFileUtils = this;
    }
}
