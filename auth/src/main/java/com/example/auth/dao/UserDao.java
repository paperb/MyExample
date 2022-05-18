package com.example.auth.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
