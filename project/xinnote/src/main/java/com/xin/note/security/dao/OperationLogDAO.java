package com.xin.note.security.dao;

import com.xin.note.common.mybatis.mapper.MyMapper;
import com.xin.note.security.entity.OperationLog;
import org.springframework.stereotype.Repository;
@Repository
public interface OperationLogDAO extends MyMapper<OperationLog> {
}