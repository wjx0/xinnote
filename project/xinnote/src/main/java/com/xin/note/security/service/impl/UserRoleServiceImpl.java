package com.xin.note.security.service.impl;

import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.UserRoleDAO;
import com.xin.note.security.entity.UserRole;
import com.xin.note.security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserRoleService实现,
*/
@Service
@Transactional
public class UserRoleServiceImpl extends MultiLanguageServiceImpl<UserRole> implements UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;

}
