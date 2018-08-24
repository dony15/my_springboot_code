package com.dony15.quartz.job;

import com.dony15.dao.CityDao;
import com.dubbo.common_domain.City;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author DonY15
 * @description
 * @create 2018/8/23
 */
@Component
@DisallowConcurrentExecution //不允许并发
public class SelectCityJob extends QuartzJobBean {

    // 该类必须为public修饰
    // 该类必须含有空参数的构造器
    public SelectCityJob() {
    }

    @Autowired
    private CityDao cityDao;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // 传入的参数
        JobDataMap params = context.getJobDetail().getJobDataMap();
        System.err.println("==============Test ( • ̀ω•́ )✧");
        System.out.println(params.getString("cityName"));
        City city = cityDao.getCityByName(params.getString("cityName"));
        System.out.println(city);

    }
}
