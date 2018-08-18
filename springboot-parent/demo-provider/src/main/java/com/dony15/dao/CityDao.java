package com.dony15.dao;

import com.dubbo.common_domain.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author DonY15
 * @description
 * @create 2018\8\16 0016
 */

public interface CityDao {

    /**
     * get city by cityName
     * @param cityName
     * @return
     */
    @Select("SELECT * FROM CITY c WHERE c.city_name=#{cityName}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "cityDesc",column = "city_desc")
    })
    City getCityByName(@Param("cityName")String cityName);


    /**
     * get city list
     * @return
     */
    @Select("SELECT * FROM CITY")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "cityDesc",column = "city_desc")
    })
    List<City> getCityList();

}
