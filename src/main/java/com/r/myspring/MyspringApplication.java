package com.r.myspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.r.myspring")
public class MyspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringApplication.class, args);
    }

}
