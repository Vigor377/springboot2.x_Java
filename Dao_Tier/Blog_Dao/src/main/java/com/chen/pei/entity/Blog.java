package com.chen.pei.entity;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_blog")
@ApiModel(value="Blog对象", description="博客")
public class Blog implements Serializable {

    @ApiModelProperty(value = "博客ID")
    @TableId(value = "id", type = IdType.AUTO)  //主键自增
    private Integer id;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客摘要")
    private String summary;     //内容摘要

    @ApiModelProperty(value = "博客发表时间")
    @TableField(fill = FieldFill.INSERT)  //自动填充时间
    private Date releaseDate;   //发表时间

    @ApiModelProperty(value = "博客点击数")
    private Integer clickHit;       //点击数

    @ApiModelProperty(value = "博客评论数")
    private Integer replyHit;       //评论数

    @ApiModelProperty(value = "博客内容")
    private String content;     //内容

    @ApiModelProperty(value = "博客类型")
    private String typeId;         //所属博客类型

    @ApiModelProperty(value = "博客关键字")
    private String keyWord;     //关键字

    @ApiModelProperty(value = "博客推荐")
    private String recommend;   //是否推荐

    @ApiModelProperty(value = "博客首图地址")
    private String imageName;   //首图地址

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic(value = "0",delval = "1")    //0显示，1不显示
    private Integer isDelete;   //逻辑删除
}
