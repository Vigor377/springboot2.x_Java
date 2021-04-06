package com.chen.pei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pei.entity.Blogger;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<Blogger> {
}
