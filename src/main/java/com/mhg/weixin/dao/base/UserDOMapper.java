package com.mhg.weixin.dao.base;

import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.dto.UserDTO;

import java.util.List;

public interface UserDOMapper {

    int deleteByPrimaryKey(String id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO selectByUserName(String userName);

    UserDTO selectAllByUserName(String userName);

    List<UserDO> list(UserDO userDO);
}