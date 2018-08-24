package com.dony15.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.common_interface.QuartzCityService;
import org.springframework.stereotype.Component;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
@Component
public class QuartzCityConsumerService {

    @Reference(version = "1.0.0",timeout = 10000)
    private QuartzCityService quartzCityService;


    public void getCityByName(String cityName){
        quartzCityService.getCityByName(cityName);
    }

}
