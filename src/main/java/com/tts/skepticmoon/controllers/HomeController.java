package com.tts.skepticmoon.controllers;

import javax.validation.Valid;

import com.tts.skepticmoon.models.User;
import com.tts.skepticmoon.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
    @Autowired
    EmailService emailService;

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

    @PostMapping("/contact")
    public String formPost(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errorMsg", "Input is not valid. Please re-enter and re-submit");
            return "/contact";
        }

        model.addAttribute("noErrors", true);
        model.addAttribute("user", user);
        model.addAttribute("successMsg", "Thank you for contacting Skeptic Moon! We will respond as soon as possible.");
        emailService.sendEmail(user);
        return "/contact";
    }
}
