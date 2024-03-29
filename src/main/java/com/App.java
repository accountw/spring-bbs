package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.repository")
@EntityScan("com.entity")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }





}
