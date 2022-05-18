package com.example.demo.shiro;

import com.example.demo.service.UserService;
import com.example.demo.token.JwtToken;
import com.example.demo.utils.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @PackageName:com.ye.back.config
 * @ClassName:MyCredentialsMatcher
 * @Description:
 * @author:何进业
 * @date:2021/6/1 7:32
 */
@Component
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private UserService userService;

    //使用自定义token
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        JwtToken jwtToken=(JwtToken) token;
        if (jwtToken.getPassword() == null){
            return true;
        }
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(jwtToken.getPassword());
        //获得数据库中的密码
        String username = String.valueOf(info.getPrincipals());
        //获取盐
        String slat = userService.getUserByUsername(username).getSalt();
//        System.out.println(StringUtil.md5(inPassword + slat));
        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        return this.equals(StringUtil.md5(inPassword + slat), dbPassword);
    }

//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
//        String inPassword = new String(usernamePasswordToken.getPassword());
//        //获得数据库中的密码
//        String username = String.valueOf(info.getPrincipals());
//        //获取盐
//        String slat = userService.getUserByUsername(username).getSalt();
////        System.out.println(StringUtil.md5(inPassword + slat));
//        String dbPassword = (String) info.getCredentials();
//        //进行密码的比对
//        return this.equals(StringUtil.md5(inPassword + slat), dbPassword);
//    }
}
