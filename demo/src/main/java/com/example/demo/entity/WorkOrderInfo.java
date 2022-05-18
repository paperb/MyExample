package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkOrderInfo implements Serializable {
    private Integer id;
    private Integer workOrderId;
    private String storePath;
    private Date createTime;
}
