package com.xin.note.security.dao;

import com.xin.note.common.mybatis.mapper.MyMapper;
import com.xin.note.security.entity.ResourceInfo;

import java.util.List;

public interface ResourceInfoDAO extends MyMapper<ResourceInfo> {
    List<ResourceInfo> getResourcesByRoleId(Long roleId);
}