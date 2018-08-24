package com.dony15.controller;

import com.dony15.dubbo.CityConsumerService;
import com.dony15.utils.FreemarkerUtil;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author DonY15
 * @description
 * @create 2018\8\19 0019
 */
@Controller
public class FreemarkerController {

    @Autowired
    private CityConsumerService cityConsumerService;

    /**
     * 根据Freemarker模板直接使用页面
     * @param model
     * @return
     */
    @RequestMapping("/freemarker/citylist")
    public String getCityList(Model model) throws Exception {
        List cityList = cityConsumerService.getCityList();
        model.addAttribute("cityList",cityList);
        return "freemarkers/citylistt";
    }


    /**
     * 根据Freemarker模板生成静态页面,需要工具类FreemarkerUtil
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/freemarker/createCitylist")
    public String createHtmlFromStringList(HttpServletRequest request) {
        try {
            FreemarkerUtil freemarkerUtil = new FreemarkerUtil();
            Template template = freemarkerUtil.getTemplate(request, "citylistt.ftl");
            String resultPath="E:/javaSoft/ProjectAll/springboot-parent/demo-consumer/src/main/resources/templates/freemarkers_template_html";
            List cityList = cityConsumerService.getCityList();
            HashMap<String, Object> map = new HashMap<>();
            map.put("cityList",cityList);
            freemarkerUtil.printToFile(template,resultPath,"cityList_fk.html",map);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }


}
