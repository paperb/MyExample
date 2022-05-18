package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PermissionDao;
import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public Set<String> getAllPermissionByUsername(String username) {
        return permissionDao.selectAllPermissionCodeByUsername(username);
    }
}
