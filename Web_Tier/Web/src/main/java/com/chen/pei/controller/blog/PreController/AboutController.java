package com.chen.pei.controller.blog.PreController;


import com.chen.pei.entity.BlogType;
import com.chen.pei.entity.Blogger;
import com.chen.pei.service.BlogTypeService;
import com.chen.pei.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Me")
public class AboutController {

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private BlogTypeService blogTypeService;

    @GetMapping("PreBloggerPage")
    public String preBloggerPage(Model model){
        Blogger blogger = bloggerService.getBlogger();
        List<BlogType> allBlogType = blogTypeService.getAllBlogType();

        model.addAttribute("allBlogType",allBlogType);
        model.addAttribute("blogger",blogger);
        return "blog/lead/about";
    }
}
