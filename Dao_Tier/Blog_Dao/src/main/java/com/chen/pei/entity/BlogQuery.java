package com.chen.pei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Blog查询对象", description="用于模糊查询")
public class BlogQuery {

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客内容")
    private String content;
}
