package com.chen.pei.result;

import lombok.Data;


public enum BaseResultEnum {
    //自定义枚举类
    SUCCESS(200,"成功"),
    ERROR(201,"失败");


    private Integer code;
    private String message;

    BaseResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
