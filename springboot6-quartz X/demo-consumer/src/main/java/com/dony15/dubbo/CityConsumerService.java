package com.dony15.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.common_domain.City;
import com.dubbo.common_interface.CityService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\18 0018
 */
@Component
public class CityConsumerService {

    @Reference(version = "1.0.0",timeout = 10000)
    private CityService cityService;

    public List getCityList() throws Exception {
        return cityService.getCityList();
    }

    public City getCityByName(String cityName){
        return cityService.getCityByName(cityName);
    }

    public Integer insertCity(City city) {
        cityService.insertCity(city);
        return city.getId();
    }

    public Integer updateCity(City city){
        return cityService.updateCity(city);

    }

    public Integer deleteCity(Integer id){
        return cityService.deleteCity(id);
    }



}
