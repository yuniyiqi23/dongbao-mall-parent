package com.msb.dongbao.portal.web.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/happy-captcha")
public class HappyCaptchaController {

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {

        HappyCaptcha.require(request, response)
                .style(CaptchaStyle.ANIM)
                .type(CaptchaType.NUMBER)
                .build()
                .finish();
    }

    @GetMapping("/verify")
    public String verify(String verifyCode, HttpServletRequest request) {

        Boolean aBoolean = HappyCaptcha.verification(request, verifyCode, true);
        if (aBoolean) {
            HappyCaptcha.remove(request);
            return "通过";
        }

        return "不通过";
    }

}
