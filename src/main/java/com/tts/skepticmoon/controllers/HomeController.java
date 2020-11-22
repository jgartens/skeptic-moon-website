package com.tts.skepticmoon.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.tts.skepticmoon.models.BlogPost;
import com.tts.skepticmoon.models.User;
import com.tts.skepticmoon.repository.BlogPostRepository;
import com.tts.skepticmoon.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
    @Autowired
    EmailService emailService;

    @Autowired
    BlogPostRepository blogPostRepository;

    private List<BlogPost> posts = new ArrayList<>();

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
    public String contact(Model model){
        model.addAttribute("user", new User());
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

    @GetMapping("/discussion")
    public String discussion(Model model){
        posts.removeAll(posts);
        for (BlogPost postFromDB : blogPostRepository.findAll()){
            posts.add(postFromDB);
        }
        model.addAttribute("posts", posts);
        model.addAttribute("blogPost", new BlogPost());
        return "/discussion";
    }

    @PostMapping("/discussion")
    public String addNewBlogPost(@Valid BlogPost blogPost, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("errorMsg", "Input is not valid. Please re-enter and re-submit");
            return "/discussion";
        }
        blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
        posts.add(blogPost);
        model.addAttribute("posts", posts);
        return "/discussion";
    }

    // @DeleteMapping("/discussion")
    // public String deletePost(@PathVariable Long id, BlogPost blogPost){
    //     blogPostRepository.deleteById(id);
    //     posts.removeAll(posts);
    //     for (BlogPost postFromDB : blogPostRepository.findAll()){
    //         posts.add(postFromDB);
    //     }
    //     return "/discussion";
    // }
}
