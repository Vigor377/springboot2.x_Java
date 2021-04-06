package com.chen.pei.controller.blog.PreController;

import com.chen.pei.entity.Blog;
import com.chen.pei.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/File")
public class FileController {

    @Autowired
    private BlogService blogService;

    //返回归档页面
    @GetMapping("FilePage")
    public String filePage(Model model){
        List<String> years = blogService.getBlogYear();

        model.addAttribute("years",years);
        return "blog/lead/file";
    }

    //根据年份查询相应博客
    @PostMapping("BlogByYear")
    public ModelAndView blogByYear(@RequestParam(name = "year",defaultValue = "2019") String year){
        ModelAndView mav = new ModelAndView();
        List<Blog> blogs = blogService.getBlogByYear(year);
        List<String> years = blogService.getBlogYear();



        mav.addObject("years",years);
        mav.addObject("blogsByYear",blogs);
        mav.setViewName("blog/lead/file");
        return mav;
    }
}
