package com.xin.note.common.annotation;

/**
 * @author xin
 */

import java.lang.annotation.*;

/**
 * 权限注解 用于检查权限 规定访问权限
 *
 * @example @Permission({roleID1,roleID2})
 * @example @Permission
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    //预留属性，暂时设值无效
    String[] value() default {};

}