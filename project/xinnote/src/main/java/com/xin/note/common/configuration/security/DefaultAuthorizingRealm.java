package com.xin.note.common.configuration.security;

import com.xin.note.security.dao.RoleInfoDAO;
import com.xin.note.security.entity.RoleInfo;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.enums.UseStatusEnum;
import com.xin.note.security.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro权限验证
 */
public class DefaultAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoDAO roleInfoDAO;
//    @Autowired
//    private ResourceInfoDAO resourceInfoDAO;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserInfo userInfo = (UserInfo)principals.getPrimaryPrincipal();
        Set<String> roleNameSet = new HashSet<>();
//        Set<String> urls = new HashSet<>();
        List<RoleInfo> roleList = roleInfoDAO.getRolesByUserId(userInfo.getId());
        for(RoleInfo role:roleList){
            roleNameSet.add(role.getRoleName());
//            List<ResourceInfo> resources = resourceInfoDAO.getResourcesByRoleId(role.getId());
//            for(ResourceInfo resource:resources){
//                urls.add(resource.getUrl());
//            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNameSet);
//        info.addStringPermissions(urls);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String username = (String) token.getPrincipal();
        UserInfo searchCondition = new UserInfo();
        searchCondition.setName(username);
        UserInfo userInfo = userInfoService.selectOne(searchCondition);
        if(userInfo==null){
            throw new UnknownAccountException("用户名不存在");
        }
        if(UseStatusEnum.DISABLE.getValue().equals(userInfo.getUsingFlag().toString())){
            throw new LockedAccountException("账户被锁定");
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),null, getName());
    }
}
