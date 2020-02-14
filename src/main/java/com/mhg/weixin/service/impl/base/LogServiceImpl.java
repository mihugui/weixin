package com.mhg.weixin.service.impl.base;

import com.mhg.weixin.bean.base.LogDO;
import com.mhg.weixin.dao.base.LogDOMapper;
import com.mhg.weixin.service.base.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 14:19
 * @Version 1.0
 **/

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDOMapper logDOMapper;

    @Override
    public void addLog(LogDO logDO) {
        logDOMapper.insertSelective(logDO);
    }
}
