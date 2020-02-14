package com.mhg.weixin.utils;

import com.mhg.weixin.bean.msg.TextReturnMsgDO;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname WeixinMessageUtil
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
public class WeixinMessageUtil {

    private static  XStream xstream = new XStream();

    /**
     * @Description TODO 解析微信服务器发过来的xml格式的消息将其转换为map
     * @param request
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @date 2020/1/29 15:00
     * @auther pwt
     */
    public static Map<String, String> parseXml(HttpServletRequest request)throws Exception{

        // 将解析结果存储在HashMap中
        Map<String, String>map =new HashMap<String, String>();
        // 从request中得到输入流
        InputStream inputStream=request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到XML的根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        // 判断又没有子元素列表
        if (elementList.size()==0){
            map.put(root.getName(), root.getText());
        }else {
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * @Description TODO
     * @param textReturnMsgDO
     * @return java.lang.String
     * @date 2020/1/29 17:53
     * @auther pwt
     */
    public static String textMessageToXml(TextReturnMsgDO textReturnMsgDO) {
        xstream.alias("xml", textReturnMsgDO.getClass());
        return xstream.toXML(textReturnMsgDO);
    }
}
