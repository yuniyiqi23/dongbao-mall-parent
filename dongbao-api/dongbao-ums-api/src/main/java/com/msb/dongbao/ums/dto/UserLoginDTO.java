package com.msb.dongbao.ums.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserLoginDTO {

    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    private String username;

    private String password;

}
