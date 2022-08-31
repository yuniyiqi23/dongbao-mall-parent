package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-member")
public class UserController {

    @Autowired
    UmsMemberService umsMemberService;

    @GetMapping("/test")
    public String test(){
        return "Hello PortalWebApplication";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserParamDTO userParamDTO){
        return umsMemberService.register(userParamDTO);
    }
}
