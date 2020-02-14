package com.mhg.weixin.bean.msg;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TextReturnMsgDO
 * @Description TODO
 * @Date 2020/1/29 17:39
 * @Created by pwt
 */

@Data
public class TextReturnMsgDO {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String Content;

}
