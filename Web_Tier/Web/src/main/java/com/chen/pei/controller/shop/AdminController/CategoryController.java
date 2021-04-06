package com.chen.pei.controller.shop.AdminController;

import com.chen.pei.entity.pojo.GoodsCategory;
import com.chen.pei.entity.vo.GoodsCategoryVo;
import com.chen.pei.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.chen.pei.service.GoodsCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("goods")
public class CategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    //展示商品列表页面
    @GetMapping("category-list")
//    @ResponseBody
    public String categoryList(Model model){
        List<GoodsCategoryVo> gcList = goodsCategoryService.selectCategoryAsList();
        model.addAttribute("gcList",gcList);
        return "shop/goods/category/category-list";
//        return gcList;
    }

    //展示商品添加页面
    @GetMapping("category-add")
    public String categoryAdd(Model model){
        List<GoodsCategory> goodsCategories = goodsCategoryService.selectTopCategory();
        model.addAttribute("topTypes",goodsCategories);
        return "shop/goods/category/category-add";
    }

    //获取二级联级
    @GetMapping("secondClass/{parentId}")
    @ResponseBody
    public List<GoodsCategory> secondClass(@PathVariable("parentId") short parentId){
        List<GoodsCategory> SecondTypes = goodsCategoryService.selectCategoryByParentId(parentId);
//        System.out.println(SecondTypes);
        return SecondTypes;
    }

    //保存商品分类
    @PostMapping("saveCategory")
    @ResponseBody
    public BaseResult saveCategory(GoodsCategory goodsCategory){
        int result = goodsCategoryService.saveCategory(goodsCategory);
        return result > 0 ? BaseResult.success() : BaseResult.error();
    }
}
