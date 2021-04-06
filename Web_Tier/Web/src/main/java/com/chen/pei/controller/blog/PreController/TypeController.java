package com.chen.pei.controller.blog.PreController;

import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogType;
import com.chen.pei.service.BlogService;
import com.chen.pei.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Types")
public class TypeController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    //获取所有类型 当导航头
    @GetMapping("AllTypes")
    public String allTypes(Model model,HttpSession session){
        List<BlogType> allBlogType = blogTypeService.getAllBlogType();
        int total = allBlogType.size();

        List<Blog> blogByType = (List<Blog>) session.getAttribute("blogByType");

        model.addAttribute("blogByType",blogByType);
        model.addAttribute("total",total);
        model.addAttribute("allBlogType",allBlogType);
        return "blog/lead/types";
    }

    //根据点击哪个类型则获取哪个类型的博客
    @GetMapping("GetBlogByType/{typeName}")
    public ModelAndView getBlogByType(@PathVariable("typeName") String typeName, HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Blog> blogByType = blogService.getBlogByType(typeName);

        session.setAttribute("blogByType",blogByType);
        mav.setViewName("redirect:/Types/AllTypes");
        return mav;
    }
}
