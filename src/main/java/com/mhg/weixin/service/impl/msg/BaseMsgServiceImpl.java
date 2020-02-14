package com.mhg.weixin.service.impl.msg;

import com.alibaba.fastjson.JSON;
import com.mhg.weixin.bean.enums.MsgTypeEnum;
import com.mhg.weixin.bean.msg.MessageReceiveDO;
import com.mhg.weixin.bean.msg.TextReturnMsgDO;
import com.mhg.weixin.dao.msg.MessageReceiveDOMapper;
import com.mhg.weixin.service.msg.BaseMsgService;
import com.mhg.weixin.utils.WeixinMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

import static com.mhg.weixin.bean.enums.MsgTypeEnum.TXET;

/**
 * @Classname BaseMsgServiceImpl
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
@Service
public class BaseMsgServiceImpl implements BaseMsgService {

    private static final Logger logger = LoggerFactory.getLogger(BaseMsgServiceImpl.class);

    @Autowired
    private MessageReceiveDOMapper messageReceiveDOMapper;


    @Override
    public String msgProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("------------微信消息开始处理-------------");

        String respMessage = null;
        Map<String, String> map = WeixinMessageUtil.parseXml(request);

        MessageReceiveDO messageReceiveDO = new MessageReceiveDO();
        messageReceiveDO.setCreateTime(new Date(Integer.parseInt(map.get("CreateTime"))));
        messageReceiveDO.setFromUserName(map.get("FromUserName"));
        messageReceiveDO.setToUserName(map.get("ToUserName"));
        String msgType = map.get("MsgType");
        messageReceiveDO.setMsgType(msgType);
        messageReceiveDO.setMsgId(Integer.getInteger(map.get("MsgId")));
        messageReceiveDO.setMsgContent(JSON.toJSONString(map));

        messageReceiveDOMapper.insertSelective(messageReceiveDO);

        switch(MsgTypeEnum.getByCode(msgType))
        {
            case TXET:
                logger.info(map.get("Content"));
                return null;
            default:
                break;
        }

        return null;
    }
}
