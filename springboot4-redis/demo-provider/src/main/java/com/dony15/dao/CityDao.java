package com.dony15.dao;

import com.dubbo.common_domain.City;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
            @Result(property = "cityDesc",column = "city_desc"),
            @Result(property = "cityImage",column = "city_image")
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
            @Result(property = "cityDesc",column = "city_desc"),
            @Result(property = "cityImage",column = "city_image")
    })
    List<City> getCityList();


    /**
     * insert new city
     * @param city
     */
    @Insert("INSERT INTO CITY(city_name,city_desc,city_image) VALUES(#{cityName},#{cityDesc},#{cityImage})")
    @Transactional(propagation = Propagation.REQUIRED)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertCity(City city);

    /**
     * update  city where id!=null and this city don't delete
     * @param city
     * @return
     */
    @Update("<script>UPDATE CITY <set><if test='cityName != null'> city_name=#{cityName},</if><if test='cityDesc != null'> city_desc=#{cityDesc},</if><if test='cityImage != null'> city_image=#{cityImage},</if></set><where> id=#{id} </where> </script>")
    @Transactional(propagation = Propagation.REQUIRED)
    int updateCity(City city);

    /**
     * delete city by id
     * @return
     */
    @Delete("DELETE FROM CITY WHERE id=#{id}")
    @Transactional(propagation = Propagation.REQUIRED)
    int deleteCity(Integer id);

}
