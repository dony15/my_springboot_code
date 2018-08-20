package com.dony15;

import com.alibaba.fastjson.JSON;
import com.dony15.dao.CityDao;
import com.dony15.utils.RedisUtil;
import com.dubbo.common_domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProviderApplicationTests {
    @Autowired
    private CityDao cityDao;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        String cityListStr = (String) redisUtil.get("CityList");
        List<City> cityListObj = JSON.parseArray(cityListStr, City.class);
        if (cityListObj != null && cityListObj.size() > 0) {
            for (int i = 0; i < cityListObj.size(); i++) {
                System.out.println(cityListObj.get(i));
            }
        } else {
            List<City> cityList = cityDao.getCityList();
            for (int i = 0; i < cityList.size(); i++) {
                if (cityList.get(i).getCityImage()==null){
                    cityList.get(i).setCityImage("");
                }
                System.out.println(cityList.get(i));
            }
            String str = JSON.toJSONString(cityList);
            redisUtil.set("CityList", str);
            //时间单位秒,有效时间2小时
            redisUtil.expire("CityList",60*60*2);
            for (int i = 0; i < cityList.size(); i++) {
                System.out.println(cityList.get(i));
            }
        }
    }
}
