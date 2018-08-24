package com.dony15;

import com.dony15.quartz.QuartzManager;
import com.dony15.quartz.job.SelectCityJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProviderApplicationTests {

    @Autowired
    private QuartzManager quartzManager;


    @Test
    public void quartzTest(){
        Map<String,Object> params=new HashMap<>();
        params.put("大白","大白白");

        quartzManager.addJob("jobName01",
                "group01","triggerName01",
                "group01", SelectCityJob.class,
                "*/3 * * * * ?",params);

    }

}



