package com.example.user.Controller;

import com.example.user.DTO.Administrator;
import com.example.user.DTO.User;
import com.example.user.Service.administratorRepository;
import com.example.user.Service.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/user")
public class UserAccount {

    @Autowired
    private userRepository userRepository;  // 通过依赖注入获取 UserRepository 对象
    @Autowired
    private administratorRepository administratorRepository;
    @GetMapping("/login")
    public ResponseEntity<?> checkUser(@RequestParam String email, @RequestParam String password) {
        int type = -1;
        int code = 404;

        String msg = "success";

        List<User> userData = userRepository.findAll();
        List<Administrator> adminData = administratorRepository.findAll();

        if (userData.isEmpty() && adminData.isEmpty()) {
            Map<String, Object> ret = new HashMap<>();
            ret.put("code",400);
            ret.put("msg","数据库中没有数据");
            return ResponseEntity.ok(ret);
        }
        Map<String, Object> ret = new HashMap<>();

        boolean userFound = false;
        for (User user : userData) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
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

//    // 类似的方式实现其他接口...
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestParam String username, @RequestParam String email,
//                                          @RequestParam String password, @RequestParam int type) {
//        // 类似的方式实现注册接口...
//    }
//
//    // 类似的方式实现其他接口...
//
//    @PostMapping("/edit")
//    public ResponseEntity<?> editUser(@RequestParam int id, @RequestParam String name, @RequestParam String password) {
//        int code = 200;
//        String msg = "success";
//
//        Optional<User> optionalUser = userRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            user.setUserName(name);
//            user.setPassword(password);
//            userRepository.save(user);
//        } else {
//            code = 400;
//            msg = "不存在该用户信息";
//        }
//
//        return ResponseEntity.ok(Map.of("code", code, "msg", msg));
//    }
}

