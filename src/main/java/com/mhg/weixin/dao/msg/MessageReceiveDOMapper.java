package com.mhg.weixin.dao.msg;

import com.mhg.weixin.bean.msg.MessageReceiveDO;

public interface MessageReceiveDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(MessageReceiveDO record);

    int insertSelective(MessageReceiveDO record);

    MessageReceiveDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MessageReceiveDO record);

    int updateByPrimaryKey(MessageReceiveDO record);
}