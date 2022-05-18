package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserRole;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
@Mapper
public interface UserRoleDao extends BaseMapper<UserRole> {

    Integer selectRoleById(Integer userId);
}
