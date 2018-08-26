package com.dony15.activetest;

import com.dubbo.common_domain.QuartzEntity;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * @author DonY15
 * @description  消息接受演示
 * @create 2018/8/24
 */
@Component
public class ActiveConsumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "testgetCityByName2.topic")
    public void receiveQueue(QuartzEntity quartz) {
        System.out.println("Consumer收到的报文为:" + quartz);
    }


}
