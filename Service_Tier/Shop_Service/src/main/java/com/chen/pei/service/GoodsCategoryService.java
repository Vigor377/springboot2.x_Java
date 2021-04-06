package com.chen.pei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pei.entity.pojo.GoodsCategory;
import com.chen.pei.entity.vo.GoodsCategoryVo;

import java.util.List;

public interface GoodsCategoryService extends IService<GoodsCategory> {

    //获取所有的顶级分类
    public List<GoodsCategory> selectTopCategory();

    //根据父类id 获取二级分类
    List<GoodsCategory> selectCategoryByParentId(short parentId);

    //保存商品分类
    int saveCategory(GoodsCategory goodsCategory);

    //获取所有商品列表
    List<GoodsCategoryVo> selectCategoryAsList();

    //根据parentId和level查询
    List<GoodsCategory> selectCategoryListByParentIdAndLevel(short parentId,Integer level);
}
