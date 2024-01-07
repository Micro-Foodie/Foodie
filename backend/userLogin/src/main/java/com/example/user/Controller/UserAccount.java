package com.example.user.Controller;

import com.example.user.DTO.Administrator;
import com.example.user.DTO.T_USER;
import com.example.user.Service.administratorRepository;
import com.example.user.Service.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/user")
public class UserAccount {

    @Autowired
    private userRepository userRepository;  // 通过依赖注入获取 UserRepository 对象
    @Autowired
    private administratorRepository administratorRepository;
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        int type = -1;
        int code = 404;
        String msg = "success";

        List<T_USER> TUSERData = userRepository.findAll();
        List<Administrator> adminData = administratorRepository.findAll();

        if (TUSERData.isEmpty() && adminData.isEmpty()) {
            Map<String, Object> ret = new HashMap<>();
            ret.put("code",400);
            ret.put("msg","数据库中没有数据");
            return ResponseEntity.ok(ret);
        }
        Map<String, Object> ret = new HashMap<>();

        boolean userFound = false;
        for (T_USER TUSER : TUSERData) {
            if (TUSER.getEmail().equals(email) && TUSER.getPassword().equals(password)) {
                ret.put("code",200);
                ret.put("msg","普通用户登录成功");
                ret.put("type",1);
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            for (Administrator admin : adminData) {
                if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                    ret.put("code",200);
                    ret.put("msg","管理员登录成功");
                    ret.put("type",0);
                    break;
                } else {
                    ret.put("code",404);
                    ret.put("msg","用户名或密码错误");
                }
            }
        }

        return ResponseEntity.ok(ret);
    }

    @GetMapping("/getInfoByEmail")
    public ResponseEntity<?> getInfoByEmail(@RequestParam String Email) {
        Map<String, Object> ret = new HashMap<>();
        List<T_USER> TUSERData = userRepository.findEmail(Email);
        List<Administrator> adminData = administratorRepository.findEmail(Email);

        if (TUSERData.isEmpty() && adminData.isEmpty()) {
            ret.put("code", 400);
            ret.put("msg", "数据库中没有数据");
            return ResponseEntity.ok(ret);
        }

        boolean userFound = false;
        if (!TUSERData.isEmpty()) {
            ret.put("code", 200);
            ret.put("msg", "success");
            ret.put("data", TUSERData.get(0));
            return ResponseEntity.ok(ret);
        }
        else if (!adminData.isEmpty()) {
            ret.put("code", 200);
            ret.put("msg", "success");
            ret.put("data", adminData.get(0));
            return ResponseEntity.ok(ret);

        }
        return ResponseEntity.ok(ret);

    }

    @GetMapping("/InfoByID")
    public ResponseEntity<?> InfoByID(@RequestParam int ID,@RequestParam int type) {
        Map<String, Object> ret = new HashMap<>();
        if(type==0){
            List<Administrator> adminData = administratorRepository.findID(ID);
            if (!adminData.isEmpty()) {
                ret.put("code", 200);
                ret.put("msg", "已返回管理员信息");
                ret.put("data", adminData.get(0));
                return ResponseEntity.ok(ret);
            }
        }
        else{
            List<T_USER> TUSERData = userRepository.findID(ID);
            if (!TUSERData.isEmpty()) {
                ret.put("code", 200);
                ret.put("msg", "已返回用户信息");
                ret.put("data", TUSERData.get(0));
                return ResponseEntity.ok(ret);
            }
        }
        ret.put("code", 400);
        ret.put("msg", "不存在用户");
        return ResponseEntity.ok(ret);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String username, @RequestParam String email,
                                          @RequestParam String password, @RequestParam int type) {
        List<T_USER> TUSERData = userRepository.findEmail(email);
        List<Administrator> adminData = administratorRepository.findEmail(email);
        Map<String, Object> ret = new HashMap<>();
        if (TUSERData.isEmpty() && adminData.isEmpty()) {
            if(type==1){
                userRepository.registerUser(username,email,password);
                ret.put("code",200);
                ret.put("msg","用户成功注册");
            }
            else{
                administratorRepository.registerAdmin(username,email,password);
                ret.put("code",200);
                ret.put("msg","管理员成功注册");
            }

            return ResponseEntity.ok(ret);
        }
        else if(!TUSERData.isEmpty()){
            ret.put("code",400);
            ret.put("msg","该邮箱已被注册成为用户");
        }
        else{
            ret.put("code",400);
            ret.put("msg","该邮箱已被注册成为管理员");
        }

        return ResponseEntity.ok(ret);
    }

//    // 类似的方式实现其他接口...
//

}

