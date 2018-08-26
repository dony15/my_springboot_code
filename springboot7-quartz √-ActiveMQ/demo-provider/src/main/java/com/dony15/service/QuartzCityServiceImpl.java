package com.dony15.service;

import com.dony15.quartz.QuartzManager;
import com.dony15.quartz.job.SelectCityJob;
import com.dubbo.common_domain.QuartzEntity;
import com.dubbo.common_interface.QuartzCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
@Service
public class QuartzCityServiceImpl implements QuartzCityService {

    @Autowired
    private QuartzManager quartzManager;

    @JmsListener(destination = "getCityByName2.topic")
    @Override
    public void getCityByName(QuartzEntity quartz) {

        Boolean exists = quartzManager.notExists(quartz.getTriggerName(), quartz.getTriggerGroupName());
        System.err.println("来自消息队列和Dubbo的数据:"+quartz+new Date());
        System.err.println("true:不存在/false:存在:"+exists);
        Map<String,Object> params=new HashMap<>();
        params.put("params",quartz.getParams());
        if (!exists){
            //如果存在该任务,那么不操作
            System.out.println("存在该任务哦,可以尝试移除");
        }else{
            //如果不存在,那么创建该任务
            quartzManager.addJob(quartz.getJobName(), quartz.getJobGroupName(),
                    quartz.getTriggerName(), quartz.getJobGroupName(),
                    SelectCityJob.class, quartz.getCron(), params);
        }

    }
}
