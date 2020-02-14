package com.mhg.weixin.bean.base.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

/**
 * @ClassName UserVO
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 14:52
 * @Version 1.0
 **/

@Data
public class LoginUserVO {

    @NotNull(message = "用户名不能为空")
    String userName;

    @NotNull(message = "密码不能为空")
    String password;
}
