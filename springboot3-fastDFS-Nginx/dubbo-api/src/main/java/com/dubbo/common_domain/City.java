package com.dubbo.common_domain;

import java.io.Serializable;

/**
 * @author DonY15
 * @description
 * @create 2018\8\16 0016
 */
public class City implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer id;
    private String cityName;
    private String cityDesc;
    private String cityImage;

    public City() {
    }


    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }

    public String[] getCityImages(){
        if (cityImage!=null||(!"".equals(cityImage))){
            return cityImage.split(",");
        }
        return null;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityDesc='" + cityDesc + '\'' +
                ", cityImage='" + cityImage + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityDesc() {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc) {
        this.cityDesc = cityDesc;
    }
}
