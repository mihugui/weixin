package com.mhg.weixin.config.shiro;

import com.mhg.weixin.bean.base.PermissionDO;
import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.dto.RoleDTO;
import com.mhg.weixin.bean.base.dto.UserDTO;
import com.mhg.weixin.service.base.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname CustomRealm
 * @Description TODO
 * @Date 2020/2/1 14:03
 * @Created by pwt
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        UserDTO userDTO = userService.getAllByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> permissions = new HashSet<>();
        Set<String> roles = new HashSet<>();

        for(RoleDTO role : userDTO.getRoles())
        {
            roles.add(role.getCode());
            for(PermissionDO permissionDO : role.getPermissions())
            {
                permissions.add(permissionDO.getCode());
            }
        }
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户输入的账号
        String username = (String)authenticationToken.getPrincipal();
        //2.通过username从数据库中查找到user实体
        UserDO user = userService.getUserByUserName(username);
        if(user == null){
            throw new UnknownAccountException("账号不存在");
        }
        //3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(username,
                        user.getPassword(),
                        ByteSource.Util.bytes(user.getUserName()),
                        getName());
        //4.用户账号状态验证等其他业务操作
        if(user.getIsUsed().equals("1")){
            throw new AuthenticationException("该账号已经被禁用");
        }
        //5.返回身份处理对象
        return simpleAuthenticationInfo;
    }
}
