package com.heng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    //post拦截
    @ResponseBody
    @GetMapping(value = "/user/login")
    public String userLogin(@RequestParam(name="+username") String username,
                            @RequestParam(name="password") String password,
                            Map<String,Object> map){
        if(!StringUtils.containsWhitespace(username)&&"123456".equals(password)){
            return "success";
        }
        else{
            map.put("usermsg","用户信息错无");
            return "fasle";

        }

    }

    @ResponseBody//@ResponseBody是返回的响应数据
    @RequestMapping("/hello")
    public String hellodemo(){
        return "hello 03springweb";
    }

    //处理首页
    @RequestMapping({"/","index.html"})
    public String indexhtml(){
        return "index";
    }


}
