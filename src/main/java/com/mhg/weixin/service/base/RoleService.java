package com.mhg.weixin.service.base;

import com.mhg.weixin.bean.base.RoleDO;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 17:09
 * @Version 1.0
 **/

public interface RoleService {

    /**
     * 新增角色
     * @param roleDO
     */
    void add(RoleDO roleDO);

    /**
     * 更新角色
     * @param roleDO
     */
    void update(RoleDO roleDO);

    /**
     * 禁用角色
     * @param id
     */
    void disable(String id);

    /**
     * 启用
     * @param id
     */
    void enable(String id);

}
