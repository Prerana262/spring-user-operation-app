package com.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        String message = "Hello, World!";
        model.addAttribute("message", message);
        return "hello";
    }
}
