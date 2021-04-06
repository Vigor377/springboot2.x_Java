package com.chen.pei.controller.blog.PreController;

import com.chen.pei.entity.Blog;
import com.chen.pei.service.BlogService;
import com.chen.pei.utils.MarkdownTransTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Detail")
public class DetailController {

    @Autowired
    private BlogService blogService;

    @GetMapping("DetailPage/{id}")
    public String detailPage(@PathVariable("id") int id, Model model){
        Blog blog = blogService.getBlogById(id);
        blogService.updateBlogClickHit(blog);

        //对文本进行HTML解析
        String content = blog.getContent();
        String contentHTML = MarkdownTransTo.markdownToHtmlExtensions(content);
        model.addAttribute("contentHTML",contentHTML);
        model.addAttribute("DetailBlog",blog);
        return "blog/lead/detail";
    }
}
