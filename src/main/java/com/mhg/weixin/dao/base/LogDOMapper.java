package com.mhg.weixin.dao.base;

import com.mhg.weixin.bean.base.LogDO;

public interface LogDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(LogDO record);

    int insertSelective(LogDO record);

    LogDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LogDO record);

    int updateByPrimaryKey(LogDO record);
}