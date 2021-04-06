package com.chen.pei.service;

import com.chen.pei.entity.Blog;
import com.chen.pei.entity.BlogType;

import java.util.List;

public interface BlogTypeService {

    List<BlogType> getAllBlogType();

    int deleteMyBlogTypeById(int id);

    int saveNewType(BlogType blogType);

    List<BlogType> getTypeByCondition(String typeCondtion);


}
