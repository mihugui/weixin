package com.mhg.weixin.web.weixin;

import com.mhg.weixin.bean.base.TokenCheckDO;
import com.mhg.weixin.service.base.TokenService;
import com.mhg.weixin.service.msg.BaseMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname BaseController
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */

@RestController
public class WeiXinController {

    private static final Logger logger = LoggerFactory.getLogger(WeiXinController.class);

    @Autowired
    private TokenService tokenCheckService;

    @Autowired
    private BaseMsgService baseMsgService;

    @RequestMapping(value = "/weixin", method = RequestMethod.GET)
    public String login(TokenCheckDO tokenCheckDO) {
        return tokenCheckService.tokenCheck(tokenCheckDO)? tokenCheckDO.getEchostr(): null ;
    }

    @RequestMapping(value = "/weixin", method = RequestMethod.POST)
    public String receive(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("------------------接受信息------------------");
        request.setCharacterEncoding("UTF-8");
        // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");
        String respXml = baseMsgService.msgProcess(request,response);

        return respXml;
    }
}
