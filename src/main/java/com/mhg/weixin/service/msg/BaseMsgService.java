package com.mhg.weixin.service.msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname BaseMsgService
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */

public interface BaseMsgService {

    String msgProcess(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
