package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import com.example.demo.token.JwtToken;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("账号或密码不能为空"));
        }
        Subject subject = SecurityUtils.getSubject();
        String token = JwtUtil.createJWT(user.getUsername(), "back", "user", 1000 * 60 * 60 * 24);
        JwtToken jwtToken = new JwtToken(token, user.getPassword());
        try {
            subject.login(jwtToken);
        } catch (UnknownAccountException e) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("账号不存在"));
        } catch (IncorrectCredentialsException e) {
            return JSON.toJSONString(new Result().setCode(402).setMessage("密码错误"));
        }
        User backUser = userService.getUserByUsername(user.getUsername());
        Integer roleId = userRoleService.selectRoleId(backUser.getUserId());
        redisTemplate.opsForValue().set(backUser.getUsername()+":role", String.valueOf(roleId));
        Map<String, Object> map = new HashMap<>();
        map.put("user", backUser);
        map.put("token", token);
        return JSON.toJSONString(new Result().setCode(200).setMessage("登陆成功").setData(map));
    }

}
