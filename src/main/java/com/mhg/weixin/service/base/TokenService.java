package com.mhg.weixin.service.base;

import com.mhg.weixin.bean.base.TokenCheckDO;

public interface TokenService {

    boolean tokenCheck(TokenCheckDO tokenCheckDO);

    void getAccessToken();

}
