package com.xin.note.security.controller;

import com.github.pagehelper.Page;
import com.xin.note.common.annotation.NeedOperationLog;
import com.xin.note.common.annotation.Permission;
import com.xin.note.common.enums.DeletedFlagEnum;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public  @ResponseBody UserInfo getOne(@PathVariable("id") String id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Long(id));
        return userInfoService.selectByPrimaryKey(userInfo);
    }

    @RequestMapping(value="/list/{pageNo}/{pageSize}",method=RequestMethod.GET)
    @Permission
    @NeedOperationLog("用户列表查询")
    public  @ResponseBody Page<UserInfo> list(@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") int pageSize,UserInfo userInfo) {
        userInfo.setDeletedFlag(DeletedFlagEnum.NOTDELETED.getValue());
        return userInfoService.selectPage(userInfo,pageNo,pageSize);
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

