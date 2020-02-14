package com.mhg.weixin.bean.enums;


/**
 * @Classname MsgTypeEnum
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
public enum MsgTypeEnum {

    TXET("text","文本消息");

    private final String code;
    private final String desc;

    MsgTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

    public static String getDescByCode(int code) {
        String label = "";
        for (MsgTypeEnum o : MsgTypeEnum.values()) {
            if (o.getCode().equals(code)) {
                label = o.getDesc();
            }
        }
        return label;
    }

    public static String getCodeByDesc(String desc) {
        String value = "";
        for (MsgTypeEnum o : MsgTypeEnum.values()) {
            if (o.getDesc().equals(desc)) {
                value = o.getCode();
            }
        }
        return value;
    }

    public static MsgTypeEnum getByCode(String code) {
        for (MsgTypeEnum msgTypeEnum : values()) {
            if (msgTypeEnum.getCode().equals(code)) {
                return msgTypeEnum;
            }
        }
        return null;
    }

}
