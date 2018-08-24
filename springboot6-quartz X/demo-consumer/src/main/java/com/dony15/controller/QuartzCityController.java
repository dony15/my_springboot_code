package com.dony15.controller;

import com.dony15.dubbo.QuartzCityConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DonY15
 * @description
 * @create 2018/8/24
 */
@Controller
public class QuartzCityController {

    @Autowired
    private QuartzCityConsumerService quartzCityConsumerService;

    @RequestMapping("quartz/{cityName}")
    public void getQuartzCityByName(@PathVariable String cityName){
            quartzCityConsumerService.getCityByName(cityName);
    }


}
