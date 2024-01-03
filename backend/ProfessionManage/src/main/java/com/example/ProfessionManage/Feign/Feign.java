package com.example.ProfessionManage.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient("userLogin")
public interface Feign {
    @GetMapping("api/user/InfoByID")
    Map<String, Object> ret(@PathVariable int UserId,@PathVariable int type);
}
