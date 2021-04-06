package com.chen.pei.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogType;
import com.chen.pei.mapper.BlogTypeMapper;
import com.chen.pei.service.BlogTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements BlogTypeService {

    @Override
    public List<BlogType> getAllBlogType() {
        List<BlogType> blogTypes = baseMapper.selectList(null);
        return blogTypes;
    }

    @Override
    public int deleteMyBlogTypeById(int id) {
        int i = baseMapper.deleteById(id);
        return i;
    }

    @Override
    public int saveNewType(BlogType blogType) {
        int insert = baseMapper.insert(blogType);
        return insert;
    }

    @Override
    public List<BlogType> getTypeByCondition(String typeCondtion) {
        QueryWrapper<BlogType> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(typeCondtion)) {
            queryWrapper.eq("type_name", typeCondtion);
        }
        List<BlogType> blogTypes = baseMapper.selectList(queryWrapper);
        return blogTypes;
    }



}
