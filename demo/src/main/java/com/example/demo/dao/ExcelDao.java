package com.example.demo.dao;

import com.example.demo.entity.Client;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface ExcelDao {

    List<Client> selectClientAll();
}
