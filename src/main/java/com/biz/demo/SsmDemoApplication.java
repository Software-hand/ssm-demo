package com.biz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.biz.demo.web.dao")
public class SsmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmDemoApplication.class, args);
    }

}
