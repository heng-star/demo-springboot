package com.heng.controller;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.heng.dao.DepartmentDao;
import com.heng.dao.EmployeeDao;
import com.heng.entity.Department;
import com.heng.entity.Employee;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeedao;

    @Autowired
    DepartmentDao departmentdao;

    //员工列表主页
    @GetMapping("/emps")
    public String selectemployees(Model model){

        Collection<Employee> employees= employeedao.getAll();
        model.addAttribute("empsdata",employees);

        return "/employee/list";
    }

    //员工添加
    @GetMapping("/addemployee")
    public String addemployee(Model model){
        Collection<Department> departments =departmentdao.getDepartments();
        model.addAttribute("depts",departments);
        return "employee/addemploy";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/addemployee")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeedao.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
//        return "/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeedao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentdao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "/employee/addemploy";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeedao.save(employee);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    public String deleteemployee(@PathVariable ("id") Integer id){
        Employee employee = employeedao.get(id);
        System.out.println("删除成功"+employee);
        employeedao.delete(id);
        return "redirect:/emps";

    }



}
