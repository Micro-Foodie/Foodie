package com.example.user.Service;

import com.example.user.DTO.T_USER;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.Mapper.AdministratorDataMapper;
import com.example.user.DTO.Administrator;
import java.util.List;
@Service
public class administratorRepository {
    @Autowired
    private AdministratorDataMapper AdministratorDataMapper;

    public List<Administrator> findAll(){
        return AdministratorDataMapper.findAll("ADMINISTRATOR");
    }
    public List<Administrator> findEmail(String Email){
        return AdministratorDataMapper.findArticleById(Email);
    }
    public List<Administrator> findID(int UserId){
        return AdministratorDataMapper.findAdminById(UserId);
    }
    public void registerAdmin(String UserName, String Email, String Password) {
        // 调用Mapper中的registerUser方法
        int rowsAffected = AdministratorDataMapper.registerAdmin(UserName, Email, Password);

        if (rowsAffected > 0) {
            System.out.println("Admin registered successfully!");
        } else {
            System.out.println("Failed to register admin.");
        }
    }
}
