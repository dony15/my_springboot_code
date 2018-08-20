package com.dony15.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dony15.dao.CityDao;
import com.dony15.utils.RedisUtil;
import com.dubbo.common_domain.City;
import com.dubbo.common_interface.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\18 0018
 */
@Service(version = "1.0.0",timeout = 10000)
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public City getCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }

    @Override
    public List<City> getCityList() throws Exception {
        String cityListStr = (String) redisUtil.get("CityList");
        List<City> cityListObj = JSON.parseArray(cityListStr, City.class);
        if (cityListObj != null && cityListObj.size() > 0) {
            for (int i = 0; i < cityListObj.size(); i++) {
                System.out.println(cityListObj.get(i));
            }
            return cityListObj;
        } else {
            List<City> cityList = cityDao.getCityList();
            for (int i = 0; i < cityList.size(); i++) {
                if (cityList.get(i).getCityImage() == null) {
                    cityList.get(i).setCityImage("");
                }
                System.out.println(cityList.get(i));
            }
            String str = JSON.toJSONString(cityList);
            redisUtil.set("CityList", str);
            //时间单位秒,有效时间2小时
            redisUtil.expire("CityList", 60 * 60 * 2);
            for (int i = 0; i < cityList.size(); i++) {
                System.out.println(cityList.get(i));
            }
            return cityList;
        }
    }



    @Override
    public void insertCity(City city) {
        cityDao.insertCity(city);
    }

    @Override
    public int updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public int deleteCity(Integer id) {
        return cityDao.deleteCity(id);
    }
}
