package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.commom.base.annotations.TokenCheck;
import com.msb.dongbao.commom.base.response.ResponseWapper;
import com.msb.dongbao.ums.dto.UserLoginDTO;
import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-member")
public class UserController {

    @Autowired
    UmsMemberService umsMemberService;

    @GetMapping("/test")
    @TokenCheck
    public String test(){
        return "Hello PortalWebApplication";
    }

    @PostMapping("/register")
    @TokenCheck(required = false)
    public ResponseWapper register(@RequestBody @Validated UserParamDTO userParamDTO){
        return umsMemberService.register(userParamDTO);
    }

    @PostMapping("/login")
    @TokenCheck(required = false)
    public ResponseWapper login(@RequestBody @Validated UserLoginDTO userLoginDTO){
        return umsMemberService.login(userLoginDTO);
    }

}
