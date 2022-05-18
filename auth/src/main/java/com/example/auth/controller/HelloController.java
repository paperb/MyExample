package com.example.auth.controller;


import com.example.auth.entity.User;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
/*@RestController=@ResponseBody+@Controller
 该Controller中的方法
 直接返回return的内容*/
@RequestMapping("hello")
public class HelloController {
    @Autowired //自动导入对象到类中，被注入的类同样被IoC容器管理
    UserService userService;
    @GetMapping("/helloworld")
    public String helloWorld(@RequestParam(value = "id")Long id) {
        User user = userService.getUser(id);
        return user.toString();
    }
}
