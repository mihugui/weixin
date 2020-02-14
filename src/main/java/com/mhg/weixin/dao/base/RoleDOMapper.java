package com.mhg.weixin.dao.base;

import com.mhg.weixin.bean.base.RoleDO;
import com.mhg.weixin.bean.base.dto.RoleDTO;

import java.util.List;

public interface RoleDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    List<RoleDTO> selectAllByUserID(String id);

    RoleDO selectByCode(RoleDO roleDO);

}