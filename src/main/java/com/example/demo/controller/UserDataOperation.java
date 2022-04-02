package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserDataOperation {

    @Autowired
    private UserCURDService userCURDService;

    @PostMapping("/private/save")
    public String save(User user) {
        System.out.println("inside save method");
        this.userCURDService.save(user);
        return "Login";
    }
}
