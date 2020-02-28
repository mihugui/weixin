package com.mhg.weixin.service.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.dto.UserDTO;
import com.mhg.weixin.bean.base.vo.UserVO;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/3 18:33
 * @Version 1.0
 **/

public interface UserService {

    UserDO getUserByUserName(String userName);

    UserDTO getAllByUserName(String username);

    void add(UserDO userDO);

    PageInfo<UserDO> listByPage(UserDO userDO, Integer pageSize, Integer pageNum);

    void changePassword(UserVO userVO);
}
