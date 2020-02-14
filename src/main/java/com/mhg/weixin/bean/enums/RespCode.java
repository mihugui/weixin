package com.mhg.weixin.bean.enums;

/**
 * @ClassName RespCode
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 9:37
 * @Version 1.0
 **/

public enum RespCode {

    SUCCESS(200,"操作成功!"),
    ERROR(500,"操作失败!"),
    PERMISSION(401,"权限不足");

    private final Integer code;
    private final String desc;

    RespCode(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
