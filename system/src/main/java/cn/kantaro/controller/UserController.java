package cn.kantaro.controller;

import cn.kantaro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.kantaro.entity.User;

@RestController
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(){
        User user = userService.getUserByUserId("9683886d85384ceda52cfd049d44c3e7");
        return user.toString();
    }

    @PostMapping("/user")
    public String createUser(User user){
        try {
            Boolean exist = userService.insertUser(user);
            User user1 = userService.getUserByEmail(user.getEmail());
            return user1.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
