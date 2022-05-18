package com.example.demo.realm;

import com.example.demo.entity.User;
import com.example.demo.service.PermissionService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.token.JwtToken;
import com.example.demo.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    //获得自己定义的token
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.iterator().next();
        Set<String> roleNames = roleService.getAllRoleNamesByUsername(username);
        Set<String> permission = permissionService.getAllPermissionByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNames);
        info.setStringPermissions(permission);
        return info;
    }

    //使用自定义token
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        String token = (String) jwtToken.getPrincipal();
        Claims claims = JwtUtil.parseJWT(token);
        String username = claims.getId();
        User user = userService.getUserByUsername(username);
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }

//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        User user = userService.getUserByUsername(username);
//        if (user == null){
//            return null;
//        }
//        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
//    }

}
