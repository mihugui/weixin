package com.mhg.weixin.bean.base.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @ClassName RoleVO
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 17:27
 * @Version 1.0
 **/

@Data
public class RoleVO {

    private String id;

    @NotNull(message = "角色名称不能为空")
    private String name;

    @NotNull(message = "角色编号不能为空")
    private String code;

    private String type;

    private String description;

}
