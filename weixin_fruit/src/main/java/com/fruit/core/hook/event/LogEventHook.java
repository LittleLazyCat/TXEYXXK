package com.fruit.core.hook.event;

import org.springframework.stereotype.Component;

import com.fruit.core.event.LogEvent;


/**
 * 处理LogEvent钩子
 * @author Beldon 2015/10/29
 */
@Component
public class LogEventHook extends EventHookSupport<LogEvent> {

    @Override
    public void init() {
        this.plugins = getPlugins(LogEventListener.class);
    }

    @Override
    public void onApplicationEvent(LogEvent event) {
        super.onEvent(event);
    }

    public interface LogEventListener extends EventListener<LogEvent> {

    }


}
