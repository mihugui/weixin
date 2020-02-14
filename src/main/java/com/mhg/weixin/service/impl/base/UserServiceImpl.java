package com.mhg.weixin.service.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.dto.UserDTO;
import com.mhg.weixin.bean.enums.DelFlagEnum;
import com.mhg.weixin.bean.enums.IsUsedEnum;
import com.mhg.weixin.dao.base.UserDOMapper;
import com.mhg.weixin.service.base.UserService;
import com.mhg.weixin.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/3 18:34
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDOMapper userDoMapper;

    @Override
    public UserDO getUserByUserName(String userName) {

        return userDoMapper.selectByUserName(userName);
    }

    @Override
    public UserDTO getAllByUserName(String username) {

        return userDoMapper.selectAllByUserName(username);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserDO userDO) {

        if(userDoMapper.selectByUserName(userDO.getUserName()) == null )
        {
            throw new RuntimeException("用户名已经存在");
        }

        userDO.setCreateDate(new Date());
        userDoMapper.insertSelective(userDO);
        userDO.setPassword(JWTUtil.encoder(userDO.getPassword(),userDO.getUserName()+userDO.getId()));
        userDoMapper.updateByPrimaryKey(userDO);

    }

    @Override
    public PageInfo<UserDO> listByPage(UserDO userDO, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        
        userDO.setDelFlag(DelFlagEnum.SAVE.getCode());
        List<UserDO> list = userDoMapper.list(userDO);

        return new PageInfo<UserDO>(list);
    }
}
