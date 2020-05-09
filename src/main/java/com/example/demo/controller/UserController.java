package com.example.demo.controller;

import com.example.demo.utils.JsonHelp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/quick")
    public String quick(){
        return "SpringBoot==================heheh";
    }

    @RequestMapping("/getUserName")
    public String getUser(){
        return "admin";
    }

}
