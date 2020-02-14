package com.mhg.weixin.bean.msg;

import lombok.Data;

import java.util.Date;
/**
 * @Classname BaseMsgDO
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
@Data
public class BaseMsgDO {

    private String ToUserName;

    private String FromUserName;

    private Date CreateTime;

    private String MsgType;

    private Integer MsgId;
}
