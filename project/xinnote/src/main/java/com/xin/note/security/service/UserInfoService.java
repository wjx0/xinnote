package com.xin.note.security.service;

import com.github.pagehelper.Page;
import com.xin.note.common.MultiLanguageService;
import com.xin.note.security.entity.RoleInfo;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.entity.vo.UserRoleVo;

import java.util.List;

public interface UserInfoService extends MultiLanguageService<UserInfo> {

    public Page<UserRoleVo> queryUserList(Integer pageNo, int pageSize, UserRoleVo userRoleVo);
}
