package com.example.demo.dao;

import com.example.demo.entity.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsDao {
    Client selectClient(Integer searchType, Integer id);
}
