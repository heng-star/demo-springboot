package com.heng.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SqlController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //DruidDataSource

    @ResponseBody
    @GetMapping("/selectdepartment")
    public Map selectdepartment(){

        List<Map<String,Object>> selectlist =jdbcTemplate.queryForList("select *" +
                " from department");
        return selectlist.get(0);
    }
}
