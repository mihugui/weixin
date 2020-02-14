package com.mhg.weixin.config;

import com.mhg.weixin.bean.enums.RespCode;
import com.mhg.weixin.utils.AjaxResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author PWT
 * @Date 2019/8/23 16:28
 * @Version 1.0
 **/

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult handleException(Exception e) {
        AjaxResult result = new AjaxResult();
        result.setRetcode(RespCode.ERROR.getCode());
        result.setRetmsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public AjaxResult handleException(RuntimeException e) {
        AjaxResult result = new AjaxResult();
        result.setRetcode(RespCode.PERMISSION.getCode());
        result.setRetmsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public AjaxResult handleException(UnauthorizedException e) {
        AjaxResult result = new AjaxResult();
        result.setRetcode(RespCode.PERMISSION.getCode());
        result.setRetmsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResult handleException(MethodArgumentNotValidException e) {
        AjaxResult result = new AjaxResult();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String errorInfo = "";
        for (ObjectError error : errors) {
            errorInfo += error.getDefaultMessage() + ";";
        }
        result.setRetcode(RespCode.ERROR.getCode());
        result.setRetmsg(errorInfo);
        return result;
    }
}
