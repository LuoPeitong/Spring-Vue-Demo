package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired   //按类型注入
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            System.out.println(e);
            return Result.error();
        }
    }
}
