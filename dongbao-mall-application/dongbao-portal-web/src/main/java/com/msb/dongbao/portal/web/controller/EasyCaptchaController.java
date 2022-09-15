package com.msb.dongbao.portal.web.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/easy-captcha")
public class EasyCaptchaController {

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 基础
//			CaptchaUtil.out(request, response);

            // 算术
//			ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(200,50);
//			// 3个数的运算
//			arithmeticCaptcha.setLen(3);
//			arithmeticCaptcha.text();
//
//			CaptchaUtil.out(arithmeticCaptcha,request,response);

            ChineseCaptcha chineseCaptcha = new ChineseCaptcha(150,50);
            CaptchaUtil.out(chineseCaptcha,request,response);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @GetMapping("/verify")
    public String verify(String verifyCode, HttpServletRequest request) {

        Boolean aBoolean = CaptchaUtil.ver(verifyCode, request);
        if (aBoolean) {
            HappyCaptcha.remove(request);
            return "通过";
        }
        return "不通过";
    }


}
