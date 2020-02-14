package com.mhg.weixin.bean.base;

import lombok.Data;

/**
 * @Classname TokenCheckDO
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
@Data
public class TokenCheckDO {

    private String signature;

    private String timestamp;

    private String nonce;

    private String echostr;

}
