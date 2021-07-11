package com.heng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//自动扫描包含


// @EnableAutoConfiguration：开启自动配置功能  在该包目录下才能自动配置；
//以前我们需要配置的东西，Spring Boot帮我们自动配置；@EnableAutoConfiguration告诉SpringBoot开启自
//动配置功能；这样自动配置才能生效；test
@Controller
public class HelloController {
    void hello01() {
        System.out.println("controller  hello");
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
