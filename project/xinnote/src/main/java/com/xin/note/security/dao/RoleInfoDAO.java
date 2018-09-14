package com.xin.note.security.dao;

import com.xin.note.common.mybatis.mapper.MyMapper;
import com.xin.note.security.entity.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleInfoDAO extends MyMapper<RoleInfo> {
    List<RoleInfo> getRolesByUserId(Long userId);
}