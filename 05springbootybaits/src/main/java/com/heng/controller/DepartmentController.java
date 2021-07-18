package com.heng.controller;

import com.heng.entity.Department;
import com.heng.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/depart/{id}")
    public Department getdeDartmentById(@PathVariable ("id") Integer id){
        Department dp=departmentMapper.getDeptById(id);
        System.out.println(dp.getId()+"__"+dp.getDepartmentName());
        return dp;
    }

    @GetMapping("/depart")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        System.out.println(department.getId()+"__"+department.getDepartmentName());
        return department;
    }

}
