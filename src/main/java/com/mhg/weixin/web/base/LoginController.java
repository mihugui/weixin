package com.mhg.weixin.web.base;

import com.mhg.weixin.bean.base.UserDO;
import com.mhg.weixin.bean.base.vo.LoginUserVO;
import com.mhg.weixin.config.Globals;
import com.mhg.weixin.service.base.UserService;
import com.mhg.weixin.utils.AjaxResult;
import com.mhg.weixin.utils.JWTUtil;
import com.mhg.weixin.utils.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author PWT
 * @Date 2019/8/16 13:53
 * @Version 1.0
 **/
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(Model model) {
        return "login/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginUserVO loginUserVO,Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(loginUserVO.getUserName(),loginUserVO.getPassword());
        Subject currentUser = SecurityUtils.getSubject();

        try {
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码不正确");
        }catch(UnknownAccountException uae){
            model.addAttribute("msg","账号不存在");
        }catch(AuthenticationException ae){
            model.addAttribute("msg","状态不正常");
        }
        if(currentUser.isAuthenticated()){
            System.out.println("认证成功");
            return "redirect:/";
        }else{
            token.clear();
            model.addAttribute("title","登陆页面");
            return "login/index";
        }
    }

    @RequestMapping("/loginError")
    public String loginError() {
        return "/error/loginError";
    }

}
