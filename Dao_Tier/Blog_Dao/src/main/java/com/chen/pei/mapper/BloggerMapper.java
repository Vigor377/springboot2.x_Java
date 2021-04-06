package com.chen.pei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.Blogger;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BloggerMapper extends BaseMapper<Blogger> {
}
