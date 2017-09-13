package com.xin.note.security.service.impl;

import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.RoleInfoDAO;
import com.xin.note.security.entity.RoleInfo;
import com.xin.note.security.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* RoleInfoService实现,
*/
@Service
@Transactional
public class RoleInfoServiceImpl extends MultiLanguageServiceImpl<RoleInfo> implements RoleInfoService {
    @Autowired
    private RoleInfoDAO roleInfoDAO;

}
