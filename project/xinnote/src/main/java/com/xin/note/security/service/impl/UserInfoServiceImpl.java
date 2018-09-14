package com.xin.note.security.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.RoleInfoDAO;
import com.xin.note.security.dao.UserInfoDAO;
import com.xin.note.security.entity.RoleInfo;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.entity.vo.UserRoleVo;
import com.xin.note.security.service.RoleInfoService;
import com.xin.note.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl extends MultiLanguageServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public Page<UserRoleVo> queryUserList(Integer pageNo, int pageSize) {
        Page<UserRoleVo> page = PageHelper.startPage(pageNo, pageSize);
        userInfoDAO.queryUserList();
        return page;
    }
}
