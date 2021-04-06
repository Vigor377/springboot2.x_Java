package com.chen.pei.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_blogger")
@ApiModel(value="Blogger对象", description="博客")
public class Blogger implements Serializable {

    @ApiModelProperty(value = "博主ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)  //mybatis-plus 长整型唯一id
    private Integer id;

    @ApiModelProperty(value = "博主姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户个人信息")
    private String profile;     //个人信息

    @ApiModelProperty(value = "用户名")
    private String nickName;    //昵称

    @ApiModelProperty(value = "用户签名")
    private String sign;        //个性签名

    @ApiModelProperty(value = "用户头像")
    private String imageName;   //头像地址
}
