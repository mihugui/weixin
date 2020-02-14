package com.mhg.weixin.bean.base.dto;

import com.mhg.weixin.bean.base.UserDO;
import lombok.Data;

import java.util.List;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 13:50
 * @Version 1.0
 **/

@Data
public class UserDTO extends UserDO {

    List<RoleDTO> roles;

}
