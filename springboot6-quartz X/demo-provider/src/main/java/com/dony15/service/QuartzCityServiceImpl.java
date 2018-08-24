package com.dony15.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dony15.dao.CityDao;
import com.dony15.quartz.QuartzManager;
import com.dony15.quartz.job.SelectCityJob;
import com.dubbo.common_domain.City;
import com.dubbo.common_interface.QuartzCityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
@Service(version = "1.0.0", timeout = 10000)
public class QuartzCityServiceImpl implements QuartzCityService {

    @Autowired
    private QuartzManager quartzManager;

    @Override
    public void getCityByName(String cityName) {
        Boolean exists = quartzManager.notExists("getCityT", "cityT");
            Map<String, Object> params = new HashMap<>();
            params.put("cityName", cityName);
        if (!exists){
            //如果存在该任务,那么不操作
            System.out.println("存在该任务哦,可以尝试移除");
        }else{
            //如果不存在,那么创建该任务
            quartzManager.addJob("getCityN", "cityJ",
                    "getCityT", "cityT",
                    SelectCityJob.class, "0/3 * * * * ?", params);
        }
    }
}
