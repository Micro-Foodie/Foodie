package com.example.ProfessionManage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.example.ProfessionManage.Mapper")
public class ProfessionManageController {

    public static void main(String[] args) {
        SpringApplication.run(ProfessionManageController.class, args);
    }

}
