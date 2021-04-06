package com.chen.pei.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.Blogger;
import com.chen.pei.mapper.BlogMapper;
import com.chen.pei.mapper.BloggerMapper;
import com.chen.pei.service.BlogService;
import com.chen.pei.service.BloggerService;
import org.springframework.stereotype.Service;

@Service
public class BloggerServiceImpl extends ServiceImpl<BloggerMapper, Blogger> implements BloggerService {

    @Override
    public Blogger getBlogger() {
        //因为只有一个博主，所以没有选择条件
        Blogger blogger = baseMapper.selectOne(null);
        return blogger;
    }

    @Override
    public void updateBlogger(Blogger blogger) {
        int update = baseMapper.update(blogger, null);
    }
}
