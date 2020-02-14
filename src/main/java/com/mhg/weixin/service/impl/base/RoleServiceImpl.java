package com.mhg.weixin.service.impl.base;

import com.mhg.weixin.bean.base.RoleDO;
import com.mhg.weixin.bean.enums.IsUsedEnum;
import com.mhg.weixin.dao.base.RoleDOMapper;
import com.mhg.weixin.dao.base.RolePermissionDOMapper;
import com.mhg.weixin.dao.base.UserRoleDOMapper;
import com.mhg.weixin.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 17:15
 * @Version 1.0
 **/

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDOMapper roleDOMapper;

    @Autowired
    private UserRoleDOMapper userRoleDOMapper;

    @Autowired
    private RolePermissionDOMapper rolePermissionDOMapper;

    @Override
    public void add(RoleDO roleDO) {

        if(roleDOMapper.selectByCode(roleDO) == null)
        {
            throw new RuntimeException("角色编号已经存在");
        }
        roleDOMapper.insertSelective(roleDO);
    }

    @Override
    public void update(RoleDO roleDO) {
        if(roleDOMapper.selectByCode(roleDO) == null)
        {
            throw new RuntimeException("角色编号已经存在");
        }
        roleDOMapper.updateByPrimaryKey(roleDO);
    }

    @Override
    public void disable(String id) {

        RoleDO roleDO = roleDOMapper.selectByPrimaryKey(id);
        roleDO.setIsUsed(IsUsedEnum.DISABLE.getCode());
        roleDOMapper.updateByPrimaryKeySelective(roleDO);
    }

    @Override
    public void enable(String id) {

        RoleDO roleDO = roleDOMapper.selectByPrimaryKey(id);
        roleDO.setIsUsed(IsUsedEnum.DISABLE.getCode());
        roleDOMapper.updateByPrimaryKeySelective(roleDO);
    }

}
