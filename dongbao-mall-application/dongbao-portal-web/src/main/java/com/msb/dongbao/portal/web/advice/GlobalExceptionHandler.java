package com.msb.dongbao.portal.web.advice;

import com.msb.dongbao.commom.base.response.ResponseWapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    public ResponseWapper exceptionHandle(BindException exception) {

        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(error -> {
            log.error("field: " + error.getField() + ", msg:" + error.getDefaultMessage());
            errorMsg.append(error.getDefaultMessage()).append("!");
        });
        return ResponseWapper.fail(errorMsg.toString());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseWapper validExceptionHandle(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(error -> {
            log.error("field: " + error.getField() + ", msg:" + error.getDefaultMessage());
            errorMsg.append(error.getDefaultMessage()).append("!");
        });

        return ResponseWapper.fail(errorMsg.toString());
    }

    // 处理运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseWapper doHandleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        e.printStackTrace();
        return ResponseWapper.fail(e.getMessage());
    }

}
