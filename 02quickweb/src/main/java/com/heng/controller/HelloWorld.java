package com.heng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody  //@ResponseBody这里表示所有的都返回给浏览器
@Controller
public class HelloWorld {

    //@ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "02quickweb  Hello World!";
    }

}
