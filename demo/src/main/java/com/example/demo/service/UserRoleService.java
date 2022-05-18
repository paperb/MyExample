package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserRole;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
public interface UserRoleService extends IService<UserRole> {

    Integer selectRoleId(Integer userId);

}
