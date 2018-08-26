package com.dony15.activetest;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */

import javax.jms.*;

import com.dubbo.common_domain.QuartzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service("activeProducer")
public class ActiveProducer {
    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;
    // 发送消息，destination是发送到的队列，message是待发送的消息
//    public void sendMessage(Destination destination, final String message){
    public void sendMessage(Destination destination, final QuartzEntity quartzEntity) throws JMSException {
//        ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
//        Connection connection = connectionFactory.createConnection();
//        connection.start();
//        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
//        MessageProducer producer = session.createProducer(destination);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        jmsTemplate.convertAndSend(destination, quartzEntity);

//        if(connection!=null){
//            connection.close();
//        }
    }
}

