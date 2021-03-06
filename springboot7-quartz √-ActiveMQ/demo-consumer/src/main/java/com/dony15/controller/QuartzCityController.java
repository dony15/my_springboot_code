package com.dony15.controller;

import com.dony15.activetest.ActiveProducer;
import com.dubbo.common_domain.QuartzEntity;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
@RestController
public class QuartzCityController {

    @Autowired
    private ActiveProducer activeProducer;

    @RequestMapping("/quartz")
    public String getQuartzCityByName(QuartzEntity quartzEntity) throws JMSException {
        //queue
        //Destination destination = new ActiveMQQueue("getCityByName2.queue");
        //topic
        Destination destination = new ActiveMQTopic("getCityByName2.topic");

        activeProducer.sendMessage(destination, quartzEntity);
        return "SUCCESS";
    }

    @RequestMapping("/testquartz")
    public String getTestQuartzCityByName(QuartzEntity quartzEntity) throws JMSException {

        Destination destination = new ActiveMQTopic("testgetCityByName2.topic");

        for (int i = 0; i < 20; i++) {
        activeProducer.sendMessage(destination, quartzEntity);
        }
        return "SUCCESS";
    }

}
