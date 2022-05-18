package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserRoleDao;
import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;
    @Override
    public Integer selectRoleId(Integer userId) {

        return userRoleDao.selectRoleById(userId);
    }
}
