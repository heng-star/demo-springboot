package com.example.controller;

import com.example.dao.StudentRepository;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student/{id}")
    public Student getstudentbyid(@PathVariable ("id") Integer id){
        Student student =studentRepository.getById(id);
        return student;
    }

    @GetMapping("/addstudent")
    public Student addstudentbyid(Student student){
        studentRepository.save(student);
        System.out.println(student);
        return student;
        //测试 /addstudent?id=001&name=xz&email=110@110.com
    }

}
