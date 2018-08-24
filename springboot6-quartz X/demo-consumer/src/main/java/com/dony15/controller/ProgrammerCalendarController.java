package com.dony15.controller;

import com.dubbo.utils.programmerCalendar.ProgrammerCalendar;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DonY15
 * @description
 * @create 2018/8/23
 */
@RestController
public class ProgrammerCalendarController {

    @RequestMapping("/programmerCalender")
    public Map<String,Object> getProgrammerCalender(){
        ProgrammerCalendar programmerCalendar = ProgrammerCalendar.getInstance();
        System.out.println("今天是：" + programmerCalendar.getTodayString());
        System.out.println("座位朝向：面向" + programmerCalendar.getDirections()[programmerCalendar.random(programmerCalendar.getIday(), 2) % programmerCalendar.getDirections().length] + "写程序，BUG 最少。");
        System.out.println("今日宜饮：" + StringUtils.join(programmerCalendar.pickRandomDrinks(2), ","));
        System.out.println("女神亲近指数：" + programmerCalendar.star(programmerCalendar.random(programmerCalendar.getIday(), 6) % 5 + 1));
        programmerCalendar.pickTodaysLuck();

        Map<String, Object> map = new HashMap<>();
        map.put("today",programmerCalendar.getTodayString());
        map.put("directions", programmerCalendar.getDirections()[programmerCalendar.random(programmerCalendar.getIday(), 2) % programmerCalendar.getDirections().length] + "写程序，BUG 最少。");
        map.put("drink",StringUtils.join(programmerCalendar.pickRandomDrinks(2), ","));
        map.put("star",programmerCalendar.star(programmerCalendar.random(programmerCalendar.getIday(), 6) % 5 + 1));
        map.put("sg",programmerCalendar.pickTodaysLuck());

        return map;


    }

}
