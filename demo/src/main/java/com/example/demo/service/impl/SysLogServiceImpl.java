package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLog;
import com.example.demo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao sysLogDao;


    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }

    @Override
    public boolean saveBatch(Collection<SysLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysLog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysLog entity) {
        return false;
    }

    @Override
    public SysLog getOne(Wrapper<SysLog> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysLog> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<SysLog> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysLog> getBaseMapper() {
        return null;
    }

    @Override
    public Class<SysLog> getEntityClass() {
        return null;
    }
}
