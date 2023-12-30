package com.example.commentManagement;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.commentManagement.Mapper")
public class CommentManagementController {

    public static void main(String[] args) {
        SpringApplication.run(CommentManagementController.class, args);
    }

}
