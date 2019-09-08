package com.example.oauth_2._no.springsec;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {


    @GetMapping("/homepage")
    public String getHomePage(){return "home page";}
}
