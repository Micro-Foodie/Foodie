package com.example.ReportManage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.example.ReportManage.Mapper")
public class ReportManageController {

    public static void main(String[] args) {
        SpringApplication.run(ReportManageController.class, args);
    }

}
