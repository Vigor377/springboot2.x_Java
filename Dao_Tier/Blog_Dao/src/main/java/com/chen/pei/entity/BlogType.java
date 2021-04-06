package com.chen.pei.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_blogtypes")
@ApiModel(value="博客类型", description="博客类型")
public class BlogType {

    @ApiModelProperty(value = "类型ID")
    @TableId(value = "id", type = IdType.AUTO)  //mybatis-plus 长整型唯一id
    private Integer id;

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "类型创建时间")
    @TableField(fill = FieldFill.INSERT)  //自动填充时间
    private Date releaseDate;   //发表时间
}
