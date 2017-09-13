package com.xin.note.security.service.impl;

import com.xin.note.common.MultiLanguageServiceImpl;
import com.xin.note.security.dao.ResourceInfoDAO;
import com.xin.note.security.entity.ResourceInfo;
import com.xin.note.security.service.ResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ResourceInfoService实现,
*/
@Service
@Transactional
public class ResourceInfoServiceImpl extends MultiLanguageServiceImpl<ResourceInfo> implements ResourceInfoService {
    @Autowired
    private ResourceInfoDAO resourceInfoDAO;

}
