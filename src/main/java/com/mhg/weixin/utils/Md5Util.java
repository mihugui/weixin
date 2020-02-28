package com.mhg.weixin.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Classname Md5Util
 * @Description TODO
 * @Date 2020/2/1 15:48
 * @Created by pwt
 */
public class Md5Util {

    public static String md5ShiroPwd(String pwd,String user)
    {
        SimpleHash simpleHash = new SimpleHash("md5", pwd, ByteSource.Util.bytes(user),2);
        return simpleHash.toHex();
    }
}
