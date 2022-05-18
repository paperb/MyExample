package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.SysLog;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import com.example.demo.utils.WebSocketCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class IndexController {
    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    UserService userService;

    @SysLog
    @RequiresAuthentication
    @RequiresPermissions("course:choose")
    @GetMapping("/getMenu")
    public String getMenu(HttpServletRequest request){
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
        //header里有token，shiro验证后，参数是username
        //1.从redis中查询菜单Permission，根据用户的角色查出对应的
        //2.redis中不存在，从数据库查
        //3.保存到redis中
//        if (username == null || StringUtils.isBlank(username)) {
//            return JSON.toJSONString(new Result().setCode(401).setMessage("未登录，请先登录"));
//        }
//        if (request.getHeader("Authorization").isEmpty()||request.getHeader("Authorization")==null) {
//            throw new UnauthenticatedException();
//        }
        Long onlineCount = WebSocketCountUtil.getOnlineCount();
        log.info("当前在线人数"+onlineCount);
        List<Map<String,Object>> menuList = userService.getMenuList();
        if (menuList == null) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("获取错误"));
        } else {
            return JSON.toJSONString(new Result().setCode(200).setMessage("获取成功").setData(menuList));
        }
    }
}
