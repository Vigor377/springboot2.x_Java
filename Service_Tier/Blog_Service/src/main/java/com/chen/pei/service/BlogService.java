package com.chen.pei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.Blogger;

import java.util.LinkedHashMap;
import java.util.List;

public interface BlogService extends IService<Blog> {

    List<Blog> getAllBlog();


    boolean deleteBlogById(int id);


    int saveMyBlog(Blog blog);

    Blog getBlogTypeById(int id);

    int updateMyBlog(Blog blog);

    List<Blog> getBlogByRecommend();

    List<Blog> getBlogByType(String typeName);

    List<String> getBlogYear();

    List<Blog> getBlogByYear(String year);

    Blog getBlogById(int id);

    void updateBlogClickHit(Blog blog);
}
