package com.xin.note.common.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping({"/"})
    public String index(){
        return"login";
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return"login";
    }

    @RequestMapping(value="/doLogin",method= RequestMethod.POST)
    public String login(String username, String password,HttpServletRequest req){
        UsernamePasswordToken token = new UsernamePasswordToken( username, password );
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch  ( UnknownAccountException uae ) {
            req.setAttribute("msg","用户不存在!");
            return"login";
        } catch  ( IncorrectCredentialsException ice ) {
            req.setAttribute("msg","密码错误!");
            return"login";
        } catch  ( LockedAccountException lae ) {
            req.setAttribute("msg","账户被锁定!");
            return"login";
        } catch  ( ExcessiveAttemptsException eae ) {
            req.setAttribute("msg","超过重试次数 ,请30秒后重试");
            return"login";
        } catch ( AuthenticationException ae ) {
            req.setAttribute("msg","登录出错");
            return"login";
        }

        req.getSession().setAttribute("username",username);

        if(SecurityUtils.getSubject().hasRole("houtai")){
            return "index";
        }else{
            return "welcome";
        }



    }

}
