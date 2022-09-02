package com.msb.dongbao.portal.web.md5;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderOrDecoderTest {

    public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        boolean matches = bCryptPasswordEncoder.matches(password, encode);
        System.out.println(matches);
    }

}
