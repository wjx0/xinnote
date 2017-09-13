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

import com.xiaoleilu.hutool.json.JSONUtil;
import com.xin.note.common.annotation.NeedOperationLog;
import com.xin.note.security.entity.OperationLog;
import com.xin.note.security.entity.UserInfo;
import com.xin.note.security.service.OperationLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

/**
 * AOP 业务日志通用工具类
 */
@Aspect
@Component
public class OperationLogAop {

    private static final Logger logger = LoggerFactory.getLogger(OperationLogAop.class);

    @Autowired
    private LogManager logManager;
    @Autowired
    private OperationLogService operationLogService;

    public void setOperationLogService(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @Pointcut(value = "@annotation(com.xin.note.common.annotation.NeedOperationLog)")
    private void cutMethodNeedLog() {
    }

    @Around("cutMethodNeedLog()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
            logger.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        //如果当前用户未登录，不做日志
        UserInfo user = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (null == user) {
            return;
        }

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] args = point.getArgs();
        String methodParameters = "MethodParameters:";
        for(Object obj:args){
            if(obj instanceof Boolean || obj instanceof Number ){
                methodParameters+= obj.toString()+",";
            }else {
                methodParameters+= JSONUtil.toJsonPrettyStr(obj)+",";
            }
        }
        //获取操作名称
        NeedOperationLog annotation = currentMethod.getAnnotation(NeedOperationLog.class);
        String bussinessName = annotation.value();

        Map<String, String> parameters = this.getRequestParameters();
        String requestParameters = "RequestParameters:"+parameters.toString();

        String result = methodParameters+requestParameters;
        if(result.length()>4000){
            result = result.substring(0,4000);
        }

        logManager.executeLog(this.bussinessLog(user.getName(), bussinessName, className, methodName, result));
    }

    /**
     * 获取所有请求的值
     */
    private  Map<String, String> getRequestParameters() {
        HashMap<String, String> values = new HashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration enums = request.getParameterNames();
        while ( enums.hasMoreElements()){
            String paramName = (String) enums.nextElement();
            String paramValue = request.getParameter(paramName);
            values.put(paramName, paramValue);
        }
        return values;
    }

    private  TimerTask bussinessLog(final String userName, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    OperationLog operationLog = new OperationLog();
                    operationLog.setUserName(userName);
                    operationLog.setBusinessName(bussinessName);
                    operationLog.setClassName(clazzName);
                    operationLog.setMethodName(methodName);
                    operationLog.setMessage(msg);
                    operationLogService.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

}
