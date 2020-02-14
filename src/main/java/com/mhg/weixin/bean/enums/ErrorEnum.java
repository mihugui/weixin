package com.mhg.weixin.bean.enums;

/**
 * @Classname ErrorEnum
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
public enum ErrorEnum {

    BUSY(-1,"系统繁忙，此时请开发者稍候再试"),
    SUCCESS(0,"请求成功"),
    SECRET_ERROR(40001,"AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性"),
    FIELD_ERROR(40002,"请确保grant_type字段值为client_credential"),
    BLACKLIST(40164,"调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置");


    private final Integer code;
    private final String desc;

    ErrorEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

    public static String getDescByCode(int code) {
        String label = "";
        for (ErrorEnum o : ErrorEnum.values()) {
            if (o.getCode() == code) {
                label = o.getDesc();
            }
        }
        return label;
    }

    public static int getCodeByDesc(String desc) {
        int value = 1;
        for (ErrorEnum o : ErrorEnum.values()) {
            if (o.getDesc().equals(desc)) {
                value = o.getCode();
            }
        }
        return value;
    }

}
