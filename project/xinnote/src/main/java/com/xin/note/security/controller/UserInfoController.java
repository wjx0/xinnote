package com.xin.note.security.controller;

import com.github.pagehelper.Page;
import com.xin.note.common.annotation.NeedOperationLog;
import com.xin.note.common.annotation.Permission;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.entity.vo.UserRoleVo;
import com.xin.note.security.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UserInfoController
 * Created by xin
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController  {

    private  static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private UserInfoService userInfoService;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public @ResponseBody UserInfo getOne(@PathVariable("id") String id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Long(id));
        return userInfoService.selectByPrimaryKey(userInfo);
    }

    @RequestMapping(value="/list/{pageNo}/{pageSize}",method=RequestMethod.POST)
    @Permission("houtai")
    @NeedOperationLog("用户列表查询")
    public String userList(ModelMap map, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") int pageSize, UserRoleVo userRoleVo) {
        Page<UserRoleVo> page = userInfoService.queryUserList(pageNo,pageSize,userRoleVo);
        map.clear();
        map.addAttribute("userList",page);
        map.addAttribute("pageNo",page.getPageNum());
        map.addAttribute("pages",page.getPages());
        map.addAttribute("total",page.getTotal());

        return "user/userList";
    }

    @RequestMapping(value="/userList",method=RequestMethod.GET)
    @Permission("houtai")
    @NeedOperationLog("用户列表页面跳转")
    public String userInfo() {
//        Page<UserRoleVo> page = userInfoService.queryUserList(1,10,null);
//        map.addAttribute("userList",page);
//        map.addAttribute("pageNo",page.getPageNum());
//        map.addAttribute("pages",page.getPages());
//        map.addAttribute("total",page.getTotal());
        return "user/userList";
    }

    @RequestMapping(value="/deleteLogical/{id}",method=RequestMethod.GET)
    public  @ResponseBody int deleteOne(@PathVariable("id") String id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Long(id));
        return userInfoService.deleteByPrimaryKeyLogical(userInfo);
    }

    @RequestMapping(value="/deleteLogical",method=RequestMethod.GET)
    @Permission
    public  @ResponseBody int logicalDeleteOne(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Long(1));
        userInfo.setRemark("测试用");
        return userInfoService.deleteLogical(userInfo);
    }
}

