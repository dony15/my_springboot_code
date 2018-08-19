package com.dony15.controller;


import com.dony15.dubbo.CityConsumerService;
import com.dubbo.common_domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/getcitylist")
    public List getCityList() {
        System.out.println("Consumer Controller");
        return cityConsumerService.getCityList();
    }


    @RequestMapping("/getcity/{cityName}")
    public City getCityByName(@PathVariable String cityName) {
        return cityConsumerService.getCityByName(cityName);
    }

    @RequestMapping("/insert")
    public Integer insertCity(City city) {
        return cityConsumerService.insertCity(city);
    }

    @RequestMapping("/update")
    public Integer updateCity(City city) {
        return cityConsumerService.updateCity(city);
    }

    @RequestMapping("/delete/{id}")
    public Integer deleteCityById(@PathVariable Integer id) {
        return cityConsumerService.deleteCity(id);
    }


    /**
     * ===================================================================================
     *
     * ResultFull style
     *
     * ===================================================================================
     */

//    /**
//     * 使用Postman 测试√ 可以查询城市列表
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public List getCityListRest() {
//        System.out.println("Consumer Controller");
//        return cityConsumerService.getCityList();
//    }
//
//    /**
//     * 使用Postman 测试√ 可以根据城市名查询
//     * @param cityName
//     * @return
//     */
//    @RequestMapping(value = "/{cityName}",method = RequestMethod.GET)
//    public City getCityByName(@PathVariable String cityName) {
//        return cityConsumerService.getCityByName(cityName);
//    }
//
//
//    /**
//     * 使用Postman 测试√ 可以插入
//     * @param city
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    public Integer insertCity(City city){
//        return cityConsumerService.insertCity(city);
//    }
//
//
//    /**
//     * 使用Postman 测试X 可能编码不识别,城市名为空
//     * @param city
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.PUT)
//    public Integer updateCity(City city){
//        return cityConsumerService.updateCity(city);
//    }
//
//    /**
//     * Request method 'DELETE' not supported 未解决,使用Postman测试X
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public Integer deleteCityById(@PathVariable Integer id){
//        return cityConsumerService.deleteCity(id);
//    }
}
