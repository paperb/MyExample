package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface PoiService {

    ResponseEntity fileUpload(MultipartFile file);


    void downLoadExcel(HttpServletResponse response);}

