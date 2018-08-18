package com.dony15.controller;


import com.dony15.dubbo.CityConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\18 0018
 */
@RestController
public class CityController {

    @Autowired
    private CityConsumerService cityConsumerService;

    @RequestMapping("/")
    public List getCityList() {
        System.out.println("Consumer Controller");
        return cityConsumerService.getCityList();
    }


//    @RequestMapping("/{cityName}")
//    public City getCityByName(@PathVariable String cityName) {
//        return cityService.getCityByName(cityName);
//    }

}
