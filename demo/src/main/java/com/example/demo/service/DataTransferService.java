package com.example.demo.service;


import com.example.demo.entity.Client;
import com.example.demo.entity.WorkOrderInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DataTransferService {
    void uploadFile(WorkOrderInfo workOrderInfo, MultipartFile workOrderId);

    void truncateList();

    boolean batchImport(String fileName, MultipartFile file) throws Exception;

    List<Client> queryClientAll();
}
