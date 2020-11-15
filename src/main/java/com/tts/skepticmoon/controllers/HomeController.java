package com.tts.skepticmoon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String main(){
        return "/home";
    }
    @GetMapping("/home")
    public String home(){
        return "/home";
    }

    @GetMapping("/bio")
    public String bio(){
        return "/bio";
    }
}