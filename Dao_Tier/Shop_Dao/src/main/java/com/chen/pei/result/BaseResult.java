package com.chen.pei.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {
    private Integer code;
    private String message;

    //成功信息
    public static BaseResult success(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseResultEnum.SUCCESS.getCode());
        baseResult.setMessage(BaseResultEnum.SUCCESS.getMessage());
        return baseResult;
    }

    //失败信息
    public static BaseResult error(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseResultEnum.ERROR.getCode());
        baseResult.setMessage(BaseResultEnum.ERROR.getMessage());
        return baseResult;
    }

}
