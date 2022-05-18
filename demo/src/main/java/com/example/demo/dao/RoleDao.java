package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Role;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */

@Mapper
public interface RoleDao extends BaseMapper<Role> {

    Set<String> selectAllRoleNamesByUsername(String username);
}
