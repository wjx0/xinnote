/**
 * Copyright (c) 2015-2017, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xin.note.common.aspect;

        import com.xin.note.common.annotation.Permission;
        import com.xin.note.common.exception.NoPermissionException;
        import com.xin.note.common.listener.ConfigListener;
        import com.xin.note.security.entity.UserInfo;
        import org.apache.shiro.SecurityUtils;
        import org.apache.shiro.subject.Subject;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.aspectj.lang.reflect.MethodSignature;
        import org.springframework.stereotype.Component;
        import org.springframework.web.context.request.RequestContextHolder;
        import org.springframework.web.context.request.ServletRequestAttributes;

        import javax.servlet.http.HttpServletRequest;
        import java.lang.reflect.Method;

/**
 * AOP 权限自定义检查
 */
@Aspect
@Component
public class PermissionAop {

    @Pointcut(value = "@annotation(com.xin.note.common.annotation.Permission)")
    private void cutPermission() {

    }

    private boolean checkAll() {
        //检查有没有url权限
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if (null == user) {
            return false;
        }
        String requestURI = request.getRequestURI().replaceFirst(ConfigListener.getConf().get("contextPath"), "");
        String[] str = requestURI.split("/");
        if (str.length > 3) {
            requestURI = "/" + str[1] + "/" + str[2];
        }
        if (this.hasPermission(requestURI)) {
            return true;
        }
        return false;
    }

    private boolean hasPermission(String requestURI) {
        return SecurityUtils.getSubject() != null && requestURI != null
                && requestURI.length() > 0
                && SecurityUtils.getSubject().isPermitted(requestURI);
    }

    @Around("cutPermission()")
    public Object doPermission(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Permission permission = method.getAnnotation(Permission.class);
        Object[] permissions = permission.value();
//        boolean hasPermission = this.checkAll();
//        if (hasPermission) {
//            return point.proceed();
//        } else {
//            throw new NoPermissionException("NoPermission");
//        }
        Subject subject=SecurityUtils.getSubject();
        int i = 0;
        for(Object role : permissions){
            if(subject.hasRole(role.toString())){
                i = 1;
            }
        }
        if(i==1){
            return point.proceed();
        }else{
            throw new NoPermissionException("NoPermission");
        }
    }

}
