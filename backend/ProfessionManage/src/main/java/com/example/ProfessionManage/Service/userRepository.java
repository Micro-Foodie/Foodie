package com.example.ProfessionManage.Service;

import com.example.ProfessionManage.DTO.T_USER;
import com.example.ProfessionManage.Feign.Feign;
import com.example.ProfessionManage.Mapper.UserDataMapper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class userRepository {
    @Autowired
    private UserDataMapper UserDataMapper;
    @Autowired
    private Feign feign;

    public List<T_USER> findAll(){
        return UserDataMapper.findAll("T_USER");
    }
    public Map<String, Object> findUserId(int UserId,int type){
        Map<String, Object> result = new HashMap<>();
        result=feign.ret(UserId,type);
        return result;
    }

}
