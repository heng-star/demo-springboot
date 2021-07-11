package com.heng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HelloWeb {


    //处理首页
//    @RequestMapping({"/","index.html"})
//    public String indexhtml(){
//        return "index";
//    }

    @ResponseBody//@ResponseBody是返回的响应数据
    @RequestMapping("/hello")
    public String hellodemo(){
        return "hello 03springweb";
    }

    @RequestMapping("/success")
    public String successdemo(Map<String,String> map){

        map.put("value1","您好，这是hello word");
        return "success";
    }



}
