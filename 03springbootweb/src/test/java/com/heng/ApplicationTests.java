package com.heng;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource datasource;

    /**
     * 测试数据库链接
     * @throws SQLException
     */
    @Test
    public void testdatasource() throws SQLException{
        System.out.println(datasource.getClass());
        Connection connection=datasource.getConnection();
        System.out.println(connection);
    }


}
