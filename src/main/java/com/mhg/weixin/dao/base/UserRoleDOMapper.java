package com.mhg.weixin.dao.base;

import com.mhg.weixin.bean.base.UserRoleDO;

import java.util.List;

public interface UserRoleDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleDO record);

    int insertSelective(UserRoleDO record);

    UserRoleDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleDO record);

    int updateByPrimaryKey(UserRoleDO record);

    List<UserRoleDO> selectByRoleID(String roleId);
}