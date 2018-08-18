package com.dony15.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dony15.dao.CityDao;
import com.dubbo.common_domain.City;
import com.dubbo.common_interface.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\18 0018
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City getCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }

    @Override
    public List<City> getCityList() {
        System.out.println("Dubbo Service getCityList==================");
        return cityDao.getCityList();
    }
}
