package com.chen.pei.controller.blog.AdminController;

import com.chen.pei.entity.BlogType;
import com.chen.pei.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/BlogType")
public class BlogTypeController {

    @Autowired
    private BlogTypeService blogTypeService;

    //条件查询类型（模糊查询显示）
    @PostMapping("BlogTypeByCondition")
    public ModelAndView blogTypeByCondition(@RequestParam("typeCondition") String typeCondtion){
        ModelAndView mav = new ModelAndView();
        List<BlogType> typeConditions = blogTypeService.getTypeByCondition(typeCondtion);
        mav.addObject("blogType",typeConditions);
        mav.setViewName("blog/types");
        return mav;
    }

    //展示博客类型页面
    @GetMapping("BlogTypePage")
    public String blogTypePage(Model model){
        List<BlogType> allBlogType = blogTypeService.getAllBlogType();
        int size = allBlogType.size();
        model.addAttribute("blogType",allBlogType);
        model.addAttribute("total",size);
        return "blog/types";
    }

    //删除博客类型
    @GetMapping("DeleteBlogTypeById/{id}")
    public ModelAndView deleteBlogTypeById(@PathVariable int id){
        ModelAndView mav = new ModelAndView();
        int flag = blogTypeService.deleteMyBlogTypeById(id);
        mav.setViewName("redirect:/BlogType/BlogTypePage");
        return mav;
    }

    //展示类型添加页面
    @GetMapping("SaveTypePage")
    public String saveTypePage(Model model){
        List<BlogType> allBlogType = blogTypeService.getAllBlogType();
        model.addAttribute("blogType",allBlogType);
        return "blog/types-insert";
    }

    //添加博客类型
    @PostMapping("SaveBlogType")
    public ModelAndView saveBlogType(BlogType blogType){
        ModelAndView mav = new ModelAndView();
        int flag = blogTypeService.saveNewType(blogType);
        mav.setViewName("redirect:/BlogType/BlogTypePage");
        return mav;
    }
}
