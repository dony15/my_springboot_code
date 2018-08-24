package com.dony15;

import com.dony15.activetest.ActiveProducer;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoConsumerApplicationTests {

    @Autowired
    private ActiveProducer activeProducer;

//    @Test
//    public void contextLoads() throws InterruptedException {
//        Destination destination = new ActiveMQQueue("mytest.queue");
//        activeProducer.sendMessage(destination, "[飞雪连天射白鹿,笑书神侠倚碧鸳]");
//    }
}
