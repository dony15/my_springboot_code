package com.dony15.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.common_interface.CityService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\18 0018
 */
@Component
public class CityConsumerService  {

    @Reference(version = "1.0.0")
    private CityService cityService;

   public List getCityList(){
       return cityService.getCityList();
    }


}
