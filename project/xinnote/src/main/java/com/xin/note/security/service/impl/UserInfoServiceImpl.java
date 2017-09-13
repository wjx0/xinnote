package com.xin.note.security.service.impl;

import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.UserInfoDAO;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserInfoService实现,
*/
@Service
@Transactional
public class UserInfoServiceImpl extends MultiLanguageServiceImpl<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoDAO userInfoDAO;

}
