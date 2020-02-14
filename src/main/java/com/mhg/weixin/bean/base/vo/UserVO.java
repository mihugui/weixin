package com.mhg.weixin.bean.base.vo;

import com.mhg.weixin.bean.PageVO;
import lombok.Data;

/**
 * @ClassName UserVO
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 18:40
 * @Version 1.0
 **/
@Data
public class UserVO extends PageVO {

    private String userName;

    private String password;

    private String phone;

    private String email;

    private String isUsed;

}
