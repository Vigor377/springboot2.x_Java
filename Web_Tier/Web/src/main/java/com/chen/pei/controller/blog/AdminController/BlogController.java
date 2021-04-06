package com.chen.pei.controller.blog.AdminController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogQuery;
import com.chen.pei.entity.BlogType;
import com.chen.pei.service.BlogService;
import com.chen.pei.service.BlogTypeService;
import com.chen.pei.service.oss.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private OssService ossService;

    //查询所有博客
    @GetMapping("BlogList")
    @ResponseBody
    public List<Blog> GetAllBlog(){
        List<Blog> list = blogService.getAllBlog();
        return list;
    }

    //分页查询博客
    @RequestMapping("BlogListByPage")
//    @ResponseBody
    public String GetBlogListByPage(Model model,
                                    @RequestParam(name = "current",defaultValue = "1") long current,
                                    @RequestParam(name = "limit",defaultValue = "5") long limit){
        Page<Blog> page = new Page<Blog>(current,limit);
        blogService.page(page, null);
        List<BlogType> typeList = blogTypeService.getAllBlogType();
        long total = page.getTotal();
        long pages = page.getPages();
        List<Blog> BlogListByPage = page.getRecords();


        long prePage = current-1;
        long nextPage = current+1;

        //解决分页超页问题
        if(current == 1){
            prePage = 1;
        }
        if(current == pages){
            nextPage = pages;
        }


        model.addAttribute("total",total);
        model.addAttribute("pages",pages);
        model.addAttribute("current",current);
        model.addAttribute("prePage",prePage);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("limit",limit);
        model.addAttribute("typeList",typeList);
        model.addAttribute("BlogListByPage",BlogListByPage);
        //用于列表页辨别是查询还是普通展示
        model.addAttribute("UrlName","BlogListByPage");
        return "blog/design";
    }

    //展示添加页面
    @GetMapping("SavePage")
    public String savePage(Model model){
        List<BlogType> typeList = blogTypeService.getAllBlogType();
        model.addAttribute("typeList",typeList);
        return "blog/insert";
    }

    //添加博客
    @PostMapping( "SaveBlog")
    public ModelAndView saveBlog(@RequestParam("imageFile") MultipartFile imageFile,Blog blog) {
        ModelAndView mav = new ModelAndView();
        if(!imageFile.isEmpty()){
            String url = ossService.uploadFileAvatar(imageFile);  //使用oss存储首图图片
            blog.setImageName(url);
        }
        int flag = blogService.saveMyBlog(blog);
        mav.setViewName("redirect:/Blog/BlogListByPage");
        return mav;
    }

    //展示修改页面
    @GetMapping("UpdatePage/{id}")
    public String updatePage(Model model,@PathVariable int id){
        List<BlogType> typeList = blogTypeService.getAllBlogType();
        Blog blog = blogService.getBlogTypeById(id);


        model.addAttribute("BlogById",blog);
        model.addAttribute("typeList",typeList);
        return "blog/update";
    }

    //修改博客
    @PostMapping("UpdateBlog")
    public ModelAndView updateBlog(@RequestParam("imageFile") MultipartFile imageFile,
                                   @RequestParam("originalFileName") String originalFileName,
                                   Blog blog) {
        ModelAndView mav = new ModelAndView();

        //如果imageFile不为空（用户有选图片）则将原来的图片删除，换成现在的图片
        if(!imageFile.isEmpty()){
//            对链接进行处理：得到文件名（数据库存储的文件名和阿里云存储的不同）
//          https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg ---> 01.jpg

//            删除原有图片
//            ossService.deleteImage(originalFileName);
//            存储新图片
            String url = ossService.uploadFileAvatar(imageFile);
            blog.setImageName(url);
        }

        //如果imageFile为空则不修改其图片
        int flag = blogService.updateMyBlog(blog);
        mav.setViewName("redirect:/Blog/BlogListByPage");
        return mav;
    }


    //根据id删除博客
    @GetMapping("DeleteBlogById/{id}")
//    @ResponseBody
    public ModelAndView deleteBlogById(@PathVariable int id){
        ModelAndView mav = new ModelAndView();
        boolean flag = blogService.deleteBlogById(id);
        mav.setViewName("redirect:/Blog/BlogListByPage");
        return mav;
    }

    //模糊查询（关键字查询博客）
    @PostMapping("BlogByCondition")
    public String blogByCondition(Model model,
                                        @RequestParam(name = "current",defaultValue = "1") long current,
                                        @RequestParam(name = "limit",defaultValue = "2") long limit,
                                        BlogQuery blogQuery){
        Page<Blog> page = new Page<>(current,limit);

        //设置wrapper条件
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        //动态sql （多条件查询）

        String typeName = blogQuery.getTypeName();
        String BlogTitle = blogQuery.getTitle();
        String BlogContent = blogQuery.getContent();

        if(!StringUtils.isEmpty(typeName)){
            wrapper.like("type_id",typeName);
        }
        if(!StringUtils.isEmpty(BlogTitle)){
            wrapper.like("title",BlogTitle);
        }
        if(!StringUtils.isEmpty(BlogContent)){
            wrapper.like("content",BlogContent);
        }

        //按创建时间排序
        wrapper.orderByDesc("release_date");

        blogService.page(page,wrapper);

        long total = page.getTotal();
        long pages = page.getPages();
        List<BlogType> typeList = blogTypeService.getAllBlogType();
        List<Blog> BlogByCondition = page.getRecords();

        long prePage = current-1;
        long nextPage = current+1;

        //解决分页超页问题
        if(current == 1){
            prePage = 1;
        }
        if(current == pages){
            nextPage = pages;
        }

        //解决上下页带参数问题
        model.addAttribute("typeName",typeName);
        model.addAttribute("title",BlogTitle);
        model.addAttribute("content",BlogContent);


        model.addAttribute("total",total);
        model.addAttribute("pages",pages);
        model.addAttribute("current",current);
        model.addAttribute("prePage",prePage);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("limit",limit);
        model.addAttribute("typeList",typeList);
        model.addAttribute("BlogListByPage",BlogByCondition);
        model.addAttribute("UrlName","BlogByCondition");
        return "blog/design";

    }

}
