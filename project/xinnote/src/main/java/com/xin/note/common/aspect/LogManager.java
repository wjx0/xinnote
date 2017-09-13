package com.xin.note.common.aspect;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日志管理器
 * 用于异步记录日志,尽量对原业务性能影响到最小
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LogManager {

    //日志记录操作延时
    private final int OPERATE_DELAY_TIME = 1000;

    //异步操作记录日志的线程池
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private LogManager() {
    }

    void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
