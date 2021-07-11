package com.heng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@ResponseBody
    //post拦截
    @PostMapping(value = "/user/login")
    public String userLogin(@RequestParam(name="username") String username,
                            @RequestParam(name="password") String password,
                            Map<String,Object> map, HttpSession session){
        if(!StringUtils.containsWhitespace(username)&&"123456".equals(password)){

            session.setAttribute("userinfo",username);

            return "redirect:/main.html";
        }
        else {
            map.put("usermsg","用户信息错无");
            return "index";

        }
//        return null;

    }
}
