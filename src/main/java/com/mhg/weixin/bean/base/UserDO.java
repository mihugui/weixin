package com.mhg.weixin.bean.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDO implements Serializable {

    private String id;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private Date createDate;

    //是否使用 0可用 1禁用
    private String isUsed;

    //是否删除 0可用 1删除
    private String delFlag;

    private static final long serialVersionUID = 1L;

}