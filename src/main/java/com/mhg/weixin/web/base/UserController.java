package com.mhg.weixin.web.base;

import com.github.pagehelper.PageInfo;
import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.dto.TableDTO;
import com.mhg.weixin.bean.base.vo.UserVO;
import com.mhg.weixin.service.base.RoleService;
import com.mhg.weixin.service.base.UserService;
import com.mhg.weixin.utils.AjaxResult;
import com.mhg.weixin.utils.DozerUtil;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author PWT
 * @Date 2019/12/4 17:40
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    /**
     * 用户页面
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        return "user/index";

    }

    /**
     * 用户列表
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult list(UserVO userVO) {

        AjaxResult ajaxResult = new AjaxResult();

        UserDO userDO = DozerUtil.map(userVO,UserDO.class);

        PageInfo<UserDO> pageInfo = userService.listByPage(userDO,userVO.getLimit(),userVO.getPage());

        ajaxResult.setData(pageInfo);

        return ajaxResult;

    }

}
