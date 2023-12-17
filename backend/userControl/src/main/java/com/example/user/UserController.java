package com.example.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.user.Mapper")
public class UserController {

    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }
  
}
