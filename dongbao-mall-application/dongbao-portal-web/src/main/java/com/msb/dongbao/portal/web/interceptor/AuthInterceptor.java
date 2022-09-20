package com.msb.dongbao.portal.web.interceptor;

import com.msb.dongbao.commom.base.annotations.TokenCheck;
import com.msb.dongbao.commom.base.constants.ExceptionConstant;
import com.msb.dongbao.commom.base.exceptions.TokenException;
import com.msb.dongbao.common.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(TokenCheck.class)){
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (!annotation.required()){
                return result;
            }
        }

        // 获取token
        String token = request.getHeader("Authorization");
        // 判断是否为空
        if (StringUtils.isBlank(token)) {
            throw new TokenException(ExceptionConstant.TOKEN_NOT_FOUND_ERROR);
        }
        try {
            String parseToken = JwtUtils.parseToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TokenException(ExceptionConstant.TOKEN_INCORRECT_ERROR);
        }
        return result;
    }
}
