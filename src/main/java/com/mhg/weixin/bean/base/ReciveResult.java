package com.mhg.weixin.bean.base;

import lombok.Data;

/**
 * @Classname ReciveResult
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
@Data
public class ReciveResult {

    String access_token;

    int expires_in;

    int errcode;

    String errmsg;

}
