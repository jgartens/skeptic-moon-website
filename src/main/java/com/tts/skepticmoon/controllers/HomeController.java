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

    @GetMapping("/music")
    public String music(){
        return "/music";
    }

    @GetMapping("/shows")
    public String shows(){
        return "/shows";
    }

    @GetMapping("/contact")
    public String contact(){
        return "/contact";
    }
}
