package com.example.demo.entity;

import lombok.Data;
import org.apache.solr.client.solrj.io.stream.DaemonStream;

import java.util.Date;


@Data
public class SysLog {

    private int id;
    private String methodName;
    private String param;
    private String result;
    private Date createTime;
}
