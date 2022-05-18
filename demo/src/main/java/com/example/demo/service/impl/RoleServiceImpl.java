package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<String> getAllRoleNamesByUsername(String username) {
        return roleDao.selectAllRoleNamesByUsername(username);
    }
}
