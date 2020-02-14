package com.mhg.weixin.bean.msg;

import lombok.Data;

import java.util.Date;

@Data
public class MessageReceiveDO {
    private String id;

    private String toUserName;

    private String fromUserName;

    private Date createTime;

    private String msgType;

    private Integer msgId;

    private String msgContent;
}