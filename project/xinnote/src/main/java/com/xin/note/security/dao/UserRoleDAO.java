package com.xin.note.security.dao;

import com.xin.note.common.mybatis.mapper.MyMapper;
import com.xin.note.security.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDAO extends MyMapper<UserRole> {
}