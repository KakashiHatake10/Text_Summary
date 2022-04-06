package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.Service.APICall;
import com.example.demo.Service.UserCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller

public class PublicController {

    @Autowired
    APICall api;

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute("message", "This is a custom message");
        System.out.println("test");

        String s = "s";
        return "message";
    }

    @PostMapping("/summaryText")
    public String getStringApi(@RequestParam("text") String text, Model model) throws IOException, InterruptedException {
        String check = api.check(text);
        model.addAttribute("message1", text);
        model.addAttribute("message2", check);
        model.addAttribute("save", 1 > 0);
        return "home";
    }

    @GetMapping("/login")
    public String login_page(Model model) {
        // model.addAttribute("user",null);
        return "Login";
    }

    @GetMapping("/register")
    public String register_page() {
        System.out.println("hi re");
        System.out.println("get");
        return "register";
    }


    @Autowired
    private UserCURDService userCURDService;

    @PostMapping("/save")
    public String save(User user) {
        System.out.println("inside save method");
        this.userCURDService.save(user);
        return "Login";
    }

    @GetMapping("/home")
    public String home() {
        return "home1";
    }
}