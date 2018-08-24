package com.dubbo.utils.programmerCalendar;


import java.util.Map;

/**
 * @auther Created by johnson.zheng
 * @pray Code is far away from bug with the animal alpaca protecting. amen!
 * @date 2018/3/27
 */
public class CalendarVo {
    private String date;
    private String direction;
    private String drink;
    private String goddess;
    private Map<String,String> goods;
    private Map<String,String> bads;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getGoddess() {
        return goddess;
    }

    public void setGoddess(String goddess) {
        this.goddess = goddess;
    }

    public Map<String, String> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, String> goods) {
        this.goods = goods;
    }

    public Map<String, String> getBads() {
        return bads;
    }

    public void setBads(Map<String, String> bads) {
        this.bads = bads;
    }
}
