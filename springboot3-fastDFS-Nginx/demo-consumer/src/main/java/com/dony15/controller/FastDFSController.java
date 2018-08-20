package com.dony15.controller;

import com.dony15.utils.FastDFSClient;
import com.dony15.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DonY15
 * @description
 * @create 2018\8\19 0019
 */
@RestController
public class FastDFSController {

    @RequestMapping(value = "/insertImage",method = RequestMethod.POST)
    public String insertImage(@RequestParam("uploadFile")MultipartFile uploadFile){
        System.out.println("开始文件上传...");
        Map<String,Object> result= null;
        try {
            result = new HashMap<>();
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
            url="http://www.dony15.com:8888/"+url;
            result.put("error",0);
            result.put("url",url);
            System.err.println(url);
            System.out.println("上传完成!");
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error",1);
            result.put("message","图片上传出错了");
            return JsonUtils.objectToJson(result);
        }

    }
}
