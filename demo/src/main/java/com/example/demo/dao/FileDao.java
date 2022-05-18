package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Client;
import com.example.demo.entity.WorkOrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
public interface FileDao extends BaseMapper {
    void insertOneFile(WorkOrderInfo workOrderInfo);
    void truncateList();

    void addClient(Client client1);

    int selectByCreateTime(Date createTime);
}
