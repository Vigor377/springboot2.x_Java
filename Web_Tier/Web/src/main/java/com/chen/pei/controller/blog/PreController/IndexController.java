package com.chen.pei.controller.blog.PreController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogType;
import com.chen.pei.entity.Blogger;
import com.chen.pei.service.BlogService;
import com.chen.pei.service.BlogTypeService;
import com.chen.pei.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private BlogTypeService blogTypeService;

    //到达前台首页
//    @GetMapping("ToIndex")
//    public String toIndex(){
//        return "lead/index";
//    }

    //展示页面
    @RequestMapping("AllBlog")
    public String allBlog(Model model,
                          @RequestParam(name = "current",defaultValue = "1") long current,
                          @RequestParam(name = "now",defaultValue = "1") long now,
                          @RequestParam(name = "limitTitle",defaultValue = "4") long limitTitle,
                          @RequestParam(name = "limit",defaultValue = "5") long limit){
        Page<Blog> page = new Page<Blog>(current,limit);  //展示左边
        Page<Blog> page1 = new Page<Blog>(now,limitTitle);  //展示目录

        blogService.page(page1,null);
        List<Blog> allBlogTitle = page1.getRecords();

        blogService.page(page, null);
        List<Blog> allBlog = page.getRecords();

        Blogger blogger = bloggerService.getBlogger();
        List<BlogType> allBlogType = blogTypeService.getAllBlogType();
        List<Blog> blogByRecommend = blogService.getBlogByRecommend();

        long total = page.getTotal();
        long pages = page.getPages();

        long pages1 = page1.getPages();

        long prePage = current-1;
        long nextPage = current+1;


        //解决分页超页问题
        if(current == 1){
            prePage = 1;
        }
        if(current == pages){
            nextPage = pages;
        }

        long prePageTitle = now-1;
        long nextPageTitle = now+1;

        //解决目录超页问题
        if(now == 1){
            prePageTitle = 1;
        }
        if(now == pages1){
            nextPageTitle = pages1;
        }

        model.addAttribute("total",total);
        model.addAttribute("pages",pages);
        model.addAttribute("limit",limit);
        model.addAttribute("limitTitle",limitTitle);
        model.addAttribute("current",current);
        model.addAttribute("prePage",prePage);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("nextPageTitle",nextPageTitle);
        model.addAttribute("prePageTitle",prePageTitle);
        model.addAttribute("allBlogTitle",allBlogTitle);
        model.addAttribute("blogger",blogger);
        model.addAttribute("allBlog",allBlog);
        model.addAttribute("blogByRecommend",blogByRecommend);
        model.addAttribute("allBlogType",allBlogType);
        return "blog/lead/index";
    }
}
