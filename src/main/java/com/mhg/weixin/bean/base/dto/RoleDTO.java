package com.mhg.weixin.bean.base.dto;

import com.mhg.weixin.bean.base.PermissionDO;
import com.mhg.weixin.bean.base.RoleDO;
import lombok.Data;

import java.util.List;

/**
 * @ClassName RoleDTO
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 13:51
 * @Version 1.0
 **/

@Data
public class RoleDTO extends RoleDO {

    List<PermissionDO> permissions;

}
