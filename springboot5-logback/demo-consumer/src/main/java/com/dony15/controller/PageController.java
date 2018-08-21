package com.dony15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DonY15
 * @description
 * @create 2018\8\19 0019
 */
@Controller
public class PageController {

    // 默认页首页
    @RequestMapping("/")
    public String goIndex(){
        return "index";
    }
    // 跳转所有内置页面
    @RequestMapping("/{page}")
    public String goPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/freemarkers/{page}")
    public String goFreemarkersPage(@PathVariable String page){
        return "freemarkers_template_html/"+page;
    }
}
