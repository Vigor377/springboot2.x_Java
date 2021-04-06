package com.chen.pei.controller.blog.AdminController;

import com.chen.pei.entity.Blogger;
import com.chen.pei.service.BloggerService;
import com.chen.pei.service.oss.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private OssService ossService;

    //展示博主信息页面
    @GetMapping("BloggerPage")
    public String bloggerPage(Model model){
        Blogger blogger = bloggerService.getBlogger();
        model.addAttribute("blogger",blogger);
        return "blog/blogger";
    }

    //展示修改页面(信息回显)
    @GetMapping("BloggerUpdatePage")
    public String bloggerUpdatePage(Model model){
        Blogger blogger = bloggerService.getBlogger();
        model.addAttribute("blogger",blogger);
        return "blog/blogger-update";
    }

    //处理修改信息
    @PostMapping("BloggerUpdate")
    public ModelAndView bloggerUpdate(Blogger blogger, @RequestParam("imageFile")MultipartFile imageFile){
        ModelAndView mav = new ModelAndView();
        if(!imageFile.isEmpty()){
            String url = ossService.uploadFileAvatar(imageFile);  //使用oss存储首图图片
            blogger.setImageName(url);
        }
        bloggerService.updateBlogger(blogger);
        mav.setViewName("redirect:/Blogger/BloggerPage");
        return mav;
    }
}
