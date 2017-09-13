package com.xin.note.common.aspect;

/**
 * @author xin
 */

import com.xin.note.common.AbstractBill;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务层切面示例,切入某个环节增加公用逻辑，比如预算占用，记录审批记录等等
 *
 * @author xin
 * @version 1.0.0
 */
@Aspect
@Order(6)
@Component
public class ServiceAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("execution(public * com.xin..*ServiceImpl.*(..))")
    public void serviceImpl(){
    }

    @Before("serviceImpl()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        AbstractBill bill  = null;
        for(Object arg:args){
            if(arg!=null) {
                Class<?> superclass = arg.getClass().getSuperclass();
                if (superclass == AbstractBill.class) {
                    bill = (AbstractBill) arg;
                }
            }
        }
        if(bill!=null) {
            logger.info("服务拦截 ====================>" + bill.toString());
        }


    }

    @AfterReturning(returning = "ret", pointcut = "serviceImpl()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，在这增加逻辑
    }


}