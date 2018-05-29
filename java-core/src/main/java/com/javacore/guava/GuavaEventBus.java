package com.javacore.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

import javax.swing.event.ChangeEvent;


/**
 * @Author qianqian.sun
 * @Date 2017/12/19
 * 描述：
 */
public class GuavaEventBus {

    EventBus eventBus = new EventBus();

    @Subscribe
    public void recordCustomerChange(ChangeEvent event) {
        System.out.println(event.getSource());
    }

    @Test
    public void eventBus() {
        eventBus.register(new GuavaEventBus());
        eventBus.post(new ChangeEvent("ss"));
    }
}
