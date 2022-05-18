package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PermissionDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Permission;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 何进业
 * @since 2021-04-30
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public User getUserByUsername(String usernmae) {
        return userDao.getUserByUsername(usernmae);
    }

    @Override
    public List<Map<String,Object>> getMenuList() {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        List<Map<String, Object>> maps = new ArrayList<>();

        String roleId = (String) redisTemplate.opsForValue().get(username + ":role");

        List<Map<String,Object>> menuList =  redisTemplate.opsForList().range(roleId + ":menu",0,-1);

        System.out.println("这是redis中菜单"+menuList);

        if (menuList == null|| menuList.isEmpty()) {
            List<Permission> list = permissionDao.selectFatherPermissionByUsername(username);
            for (Permission s : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("menu", s);
                List<Permission> subList = permissionDao.selectSubPermissionByFatherId(s.getPermissionId());
                map.put("subMenu", subList);
                maps.add(map);
                redisTemplate.opsForList().rightPushAll(roleId+":menu",map);
            }
            return maps;
        } else {
            return menuList;
        }

    }


}
