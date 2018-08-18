package com.dubbo.common_interface;


import com.dubbo.common_domain.City;

import java.util.List;

public interface CityService {
    /**
     * get city by cityName
     * @param cityName
     * @return
     */
    City getCityByName(String cityName);


    /**
     * get city list
     * @return
     */
    List<City> getCityList();
}
