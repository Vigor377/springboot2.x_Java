package com.chen.pei.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_goods_category")
@ApiModel(value="商品对象Vo", description="商品")
public class GoodsCategoryVo {

    @ApiModelProperty(value = "孩子列表")
    private List<GoodsCategoryVo> children;

    @ApiModelProperty(value = "商品分类id")
    @TableId(value = "id", type = IdType.AUTO)  //主键自增
    private Short id;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "手机端显示的商品分类名")
    private String mobileName;

    @ApiModelProperty(value = "父id")
    private Short parentId;

    @ApiModelProperty(value = "家族图谱")
    private String parentIdPath;

    @ApiModelProperty(value = "等级")
    private Integer level;

    @ApiModelProperty(value = "顺序排序")
    private Integer sortOrder;

    @ApiModelProperty(value = "是否显示")
    private Integer isShow;

    @ApiModelProperty(value = "分类图片")
    private String image;

    @ApiModelProperty(value = "是否推荐为热门分类")
    private Integer isHot;

    @ApiModelProperty(value = "分类分组默认0")
    private Integer catGroup;

    @ApiModelProperty(value = "分佣比例")
    private Integer commissionRate;
}
