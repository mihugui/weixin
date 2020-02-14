package com.mhg.weixin.dao.base;

import com.mhg.weixin.bean.base.RolePermissionDO;

public interface RolePermissionDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePermissionDO record);

    int insertSelective(RolePermissionDO record);

    RolePermissionDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePermissionDO record);

    int updateByPrimaryKey(RolePermissionDO record);

    int deleteByRoleID(String roleId);
}