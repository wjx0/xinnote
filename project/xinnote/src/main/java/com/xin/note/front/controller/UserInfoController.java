package com.xin.note.front.controller;

import com.github.pagehelper.Page;
import com.xin.note.common.annotation.NeedOperationLog;
import com.xin.note.common.annotation.Permission;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.entity.vo.UserRoleVo;
import com.xin.note.security.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * UserInfoController
 * Created by xin
 */
@Controller
@RequestMapping("/front/userInfo")
public class UserInfoController {

    private  static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public  @ResponseBody UserInfo getOne(@PathVariable("id") String id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Long(id));
        return userInfoService.selectByPrimaryKey(userInfo);
    }

    @RequestMapping(value="/list/{pageNo}/{pageSize}",method=RequestMethod.GET)
    @Permission("houtai")
    @NeedOperationLog("用户列表查询")
    public String list(ModelMap map, @PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") int pageSize ) {
        Page<UserRoleVo> page = userInfoService.queryUserList(pageNo,pageSize);
        Map<String,Object> modelMap = new HashMap<String,Object>();
        map.addAttribute("userList",page.getResult());
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

