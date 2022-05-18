package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SysLog;

public interface SysLogService extends IService<SysLog> {

    void saveSysLog(SysLog sysLog);
}
