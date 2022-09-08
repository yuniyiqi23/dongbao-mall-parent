package com.msb.dongbao.portal.web.interceptor;

import com.msb.dongbao.commom.base.constants.ExceptionConstant;
import com.msb.dongbao.commom.base.exceptions.TokenException;
import com.msb.dongbao.common.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = true;
        String resultString = null;

        // 获取token
        String token = request.getHeader("Authorization");
        // 判断是否为空
        if (StringUtils.isBlank(token)) {
            throw new TokenException(ExceptionConstant.NO_TOKEN_MESSAGE);
        }
        try {
            String parseToken = JwtUtils.parseToken(token);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
