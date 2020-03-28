package com.example.security.controller;

import com.example.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userSerivce) {
        this.userService = userSerivce;
    }

    @GetMapping("/list")
    public String getList() {
        return "user/list";
    }

}
