package com.xin.note.security.service.impl;

import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.OperationLogDAO;
import com.xin.note.security.entity.OperationLog;
import com.xin.note.security.service.OperationLogService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OperationLogService实现,
*/
@Service
@Transactional
public class OperationLogServiceImpl extends MultiLanguageServiceImpl<OperationLog> implements OperationLogService {
    @Autowired
    private OperationLogDAO operationLogDAO;

}
