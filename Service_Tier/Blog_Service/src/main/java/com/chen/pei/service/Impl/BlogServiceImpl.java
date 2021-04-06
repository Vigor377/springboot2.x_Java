package com.chen.pei.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogType;
import com.chen.pei.entity.Blogger;
import com.chen.pei.mapper.BlogMapper;
import com.chen.pei.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService {


    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = baseMapper.selectList(null);
        return blogs;
    }

    @Override
    public boolean deleteBlogById(int id) {
        int i = baseMapper.deleteById(id);
        if(i >= 0){
            return true;  //删除成功
        }else{
            return false;   //删除失败
        }
    }

    @Override
    public int saveMyBlog(Blog blog) {
        int insert = baseMapper.insert(blog);
        return insert;
    }

    @Override
    public Blog getBlogTypeById(int id) {
        Blog blog = baseMapper.selectById(id);
        return blog;
    }

    @Override
    public int updateMyBlog(Blog blog) {
        int i = baseMapper.updateById(blog);
        return i;
    }

    @Override
    public List<Blog> getBlogByRecommend() {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("recommend","yes");
        List<Blog> blogs = baseMapper.selectList(queryWrapper);
        return blogs;
    }

    @Override
    public List<Blog> getBlogByType(String typeName) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(typeName)) {
            queryWrapper.like("type_id", typeName);
        }
        List<Blog> blogs = baseMapper.selectList(queryWrapper);
        return blogs;
    }

    @Override
    public List<String> getBlogYear() {
        List<String> list = new LinkedList<>();
        list.add("2021");
        list.add("2020");
        list.add("2019");
        return list;
    }

    @Override
    public List<Blog> getBlogByYear(String year) {
        List<Blog> blogs = new LinkedList<>();

        List<Blog> blogs1 = baseMapper.selectList(null);
        for(Blog blog : blogs1){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            String format = formatter.format(blog.getReleaseDate());
            if(year.equals(format)){
                blogs.add(blog);
            }
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        Blog blog = baseMapper.selectById(id);
        return blog;
    }

    @Override
    public void updateBlogClickHit(Blog blog) {
        //对浏览次数进行处理
        Integer clickHit = blog.getClickHit();
        clickHit += 1;
        blog.setClickHit(clickHit);
        baseMapper.updateById(blog);
    }


}
