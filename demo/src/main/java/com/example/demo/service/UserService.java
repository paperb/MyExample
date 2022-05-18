package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;


import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
public interface UserService extends IService<User> {

    User getUserByUsername(String usernmae);

    List<Map<String,Object>>  getMenuList();

}
