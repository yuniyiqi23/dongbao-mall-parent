package com.msb.dongbao.commom.base.response;

import com.msb.dongbao.commom.base.enums.CommonStatusEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseWapper<T> {

    private Integer code;
    private String message;
    private T data;

    public static ResponseWapper success(){
        return ResponseWapper.builder().code(CommonStatusEnum.SUCCESS.getCode())
                .message(CommonStatusEnum.SUCCESS.getMessage()).build();
    }

    public static <T> ResponseWapper success(T data){
        return ResponseWapper.builder().code(CommonStatusEnum.SUCCESS.getCode())
                .message(CommonStatusEnum.SUCCESS.getMessage()).data(data).build();
    }

    public static ResponseWapper fail(){
        return ResponseWapper.builder().code(CommonStatusEnum.FAIL.getCode())
                .message(CommonStatusEnum.FAIL.getMessage()).build();
    }

    public static <T> ResponseWapper fail(T data){
        return ResponseWapper.builder().code(CommonStatusEnum.FAIL.getCode())
                .message(CommonStatusEnum.FAIL.getMessage()).data(data).build();
    }

}
