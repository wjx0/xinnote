package com.xin.note.security.dao;

import com.xin.note.common.mybatis.mapper.MyMapper;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.entity.vo.UserRoleVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserInfoDAO extends MyMapper<UserInfo> {
    public List<UserRoleVo> queryUserList(UserRoleVo userRoleVo);
}