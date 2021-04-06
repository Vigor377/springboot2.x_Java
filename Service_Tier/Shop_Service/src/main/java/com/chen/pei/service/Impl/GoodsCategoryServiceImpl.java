package com.chen.pei.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.pei.entity.pojo.GoodsCategory;
import com.chen.pei.entity.vo.GoodsCategoryVo;
import com.chen.pei.mapper.GoodsCategoryMapper;
import com.chen.pei.service.GoodsCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;


    @Override
    public List<GoodsCategory> selectTopCategory() {
        List<GoodsCategory> topTypes = goodsCategoryMapper.selectTopCategory();
        return topTypes;
    }

    @Override
    public List<GoodsCategory> selectCategoryByParentId(short parentId) {
        List<GoodsCategory> secondTypes = goodsCategoryMapper.selectCategoryByParentId(parentId);
        return secondTypes;
    }

    @Override
    public int saveCategory(GoodsCategory goodsCategory) {
        int insert = goodsCategoryMapper.insert(goodsCategory);
        return insert;
    }

    @Override
    public List<GoodsCategoryVo> selectCategoryAsList() {
        //获取一级分类
        List<GoodsCategory> list1 = goodsCategoryMapper.selectTopCategory();
        List<GoodsCategoryVo> gcList1 = new ArrayList<>();
        for(GoodsCategory inList1 : list1){
            GoodsCategoryVo inListVo1 = new GoodsCategoryVo();
            BeanUtils.copyProperties(inList1,inListVo1);
            Short parentId1 = inList1.getParentId();
            //获取二级分类
            List<GoodsCategory> list2 = goodsCategoryMapper.selectCategoryListByParentIdAndLevel(parentId1, 2);
            List<GoodsCategoryVo> gcList2 = new ArrayList<>();
            for(GoodsCategory inList2 : list2){
                GoodsCategoryVo inListVo2 = new GoodsCategoryVo();
                BeanUtils.copyProperties(inList2,inListVo2);
                Short parentId2 = inList2.getParentId();
                //获取三级分类
                List<GoodsCategory> list3 = goodsCategoryMapper.selectCategoryListByParentIdAndLevel(parentId2, 3);
                List<GoodsCategoryVo> gcList3 = new ArrayList<>();
                for(GoodsCategory inList3 : list3){
                    GoodsCategoryVo inListVo3 = new GoodsCategoryVo();
                    BeanUtils.copyProperties(inList3,inListVo3);
                    gcList3.add(inListVo3);
                }

                inListVo2.setChildren(gcList3);
                gcList2.add(inListVo2);
            }
            inListVo1.setChildren(gcList2);
            gcList1.add(inListVo1);
        }
        return gcList1;
    }

    @Override
    public List<GoodsCategory> selectCategoryListByParentIdAndLevel(short parentId, Integer level) {
        List<GoodsCategory> list = goodsCategoryMapper.selectCategoryListByParentIdAndLevel(parentId,level);
        return list;
    }
}
