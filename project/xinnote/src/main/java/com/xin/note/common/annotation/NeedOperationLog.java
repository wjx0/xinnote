package com.xin.note.common.annotation;

import java.lang.annotation.*;

/**
 * 标记需要做业务日志的方法
 *
 * @author xin
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NeedOperationLog {

    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

}
