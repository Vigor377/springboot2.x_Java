package com.chen.pei.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.pei.entity.Blogger;
import com.chen.pei.mapper.BloggerMapper;
import com.chen.pei.mapper.LoginMapper;
import com.chen.pei.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Blogger> implements LoginService {

    @Override
    public Blogger findLogin(String nickName, String password) {
        QueryWrapper<Blogger> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name",nickName);
        queryWrapper.eq("password",password);
        Blogger blogger = baseMapper.selectOne(queryWrapper);
        return blogger;
    }

    @Override
    public Blogger findLoginByName(String username) {
        QueryWrapper<Blogger> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name",username);
        Blogger blogger = baseMapper.selectOne(queryWrapper);
        return blogger;
    }
}
