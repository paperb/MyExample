package com.example.demo.aop.aspect;

import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLog;
import com.example.demo.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SysLogAspect {
    @Autowired
    SysLogService sysService;

    Date runtime = new Date();

    @Pointcut("@annotation(com.example.demo.annotation.SysLog)")
    public void sysLogCut(){
    }

    @Before("sysLogCut()")
    public void before(JoinPoint joinPoint){
        runtime= new Date();
    }

    @AfterReturning("sysLogCut()")
    public void after(JoinPoint joinPoint){
        ServletRequestAttributes  requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();

        //
        SysLog sysLog = new SysLog();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        sysLog.setMethodName(method.getName());

        StringBuilder params= new StringBuilder();
        for (Class<?> parameterType : method.getParameterTypes()) {
            params.append(parameterType).append(",");
        }
        StringUtils.substringBeforeLast(params.toString(),",");

        sysLog.setParam(params.toString());
        sysLog.setResult(String.valueOf(method.getReturnType()));
        sysLog.setCreateTime(runtime);

        System.out.println(sysLog);
        sysService.saveSysLog(sysLog);
    }
}
