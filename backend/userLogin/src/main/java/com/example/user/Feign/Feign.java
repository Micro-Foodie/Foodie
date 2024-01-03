package com.example.user.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ReportManage")
public interface Feign {
}
