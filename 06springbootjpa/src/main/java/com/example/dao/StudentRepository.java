package com.example.dao;

import com.example.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//继承JpaRepository来完成对数据库的操作
public interface StudentRepository extends JpaRepository<Student,Integer> {


}
