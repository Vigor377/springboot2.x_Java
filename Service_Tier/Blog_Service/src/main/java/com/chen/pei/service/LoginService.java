package com.chen.pei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pei.entity.Blog;
import com.chen.pei.entity.Blogger;


public interface LoginService extends IService<Blogger> {

    Blogger findLogin(String nickName,String password);

    Blogger findLoginByName(String username);

}
