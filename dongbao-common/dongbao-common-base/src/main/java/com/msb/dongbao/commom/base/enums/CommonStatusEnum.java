package com.msb.dongbao.commom.base.enums;

import lombok.Getter;

public enum CommonStatusEnum {

    /**
     * 成功
     */
    SUCCESS(1,"success"),
    /**
     * 失败
     */
    FAIL(0,"fail"),
    ;

    @Getter
    private Integer code;
    @Getter
    private String message;

    CommonStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
