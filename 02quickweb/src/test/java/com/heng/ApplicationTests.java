package com.heng;

import com.heng.entity.Dog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired//元注解信信息，相当于new一个对象
    Dog dog;

    @Test
    void yamltest(){
        System.out.println("dog1:"+dog);
    }
}
