package com.msb.dongbao.portal.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-member")
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "Hello PortalWebApplication";
    }

    @PostMapping("/register")
    public String register(){
        return "register";
    }
}
