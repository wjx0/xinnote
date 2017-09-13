package com.xin.note.common.configuration;

import com.xin.note.common.exception.NoPermissionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局默认异常处理
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
    /**
     * 无权访问该资源
     */
    @ExceptionHandler(NoPermissionException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String credentials(NoPermissionException e) {
        logger.error("权限异常!", e);
        return  "403";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
        logger.error("全局异常拦截:",e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("status",res.getStatus());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
