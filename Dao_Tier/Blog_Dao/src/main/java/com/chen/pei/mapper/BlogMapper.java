package com.chen.pei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pei.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
}
