package com.chen.pei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pei.entity.pojo.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    //获取所有的顶级分类
    @Select("SELECT * FROM t_goods_category WHERE parent_id = 0 AND level = 1")
    public List<GoodsCategory> selectTopCategory();

    //根据父类id 获取二级分类
    @Select("SELECT * FROM t_goods_category WHERE parent_id = #{parentId}")
    List<GoodsCategory> selectCategoryByParentId(short parentId);

    //根据parentId和level查询
    @Select("SELECT * FROM t_goods_category WHERE parent_id = #{parentId} AND level = #{level}")
    List<GoodsCategory> selectCategoryListByParentIdAndLevel(short parentId, Integer level);
}
