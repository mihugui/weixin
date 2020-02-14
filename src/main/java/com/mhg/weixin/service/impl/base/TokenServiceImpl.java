package com.mhg.weixin.service.impl.base;

import com.alibaba.fastjson.JSONObject;
import com.mhg.weixin.bean.base.ReciveResult;
import com.mhg.weixin.bean.base.TokenCheckDO;
import com.mhg.weixin.config.Globals;
import com.mhg.weixin.config.WeixinConfig;
import com.mhg.weixin.service.base.TokenService;
import com.mhg.weixin.utils.HttpUtil;
import com.mhg.weixin.utils.SHA1Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @Classname TokenServiceImpl
 * @Description TODO
 * @Date 2020/1/29 14:52
 * @Created by pwt
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private WeixinConfig weixinConfig;

    @Override
    public boolean tokenCheck(TokenCheckDO tokenCheckDO) {
        ArrayList<String> list=new ArrayList<String>();

        list.add(tokenCheckDO.getNonce());
        list.add(tokenCheckDO.getTimestamp());
        list.add(weixinConfig.getToken());
        Collections.sort(list);
        String checkSignature = SHA1Util.encode(list.get(0)+list.get(1)+list.get(2));

        if(checkSignature.equals(tokenCheckDO.getSignature()))
        {
            return true;
        }

        return false;
    }

    @Override
    public void getAccessToken() {

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","client_credential");
        map.add("appid",weixinConfig.getAppid());
        map.add("secret",weixinConfig.getAppSecret());

        for(String url : weixinConfig.getUrl())
        {
            String result = HttpUtil.get(url+"/token",map);
            ReciveResult reciveResult = JSONObject.parseObject(result,ReciveResult.class);
            if(!reciveResult.getAccess_token().equals(null))
            {
                continue;
            }else{

                Globals.ACCESS_TOKEN = reciveResult.getAccess_token();
                Globals.TOKEN_FLAG = true;
                break;

            }

        }
    }
}
