package com.chen.pei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pei.entity.Blogger;

public interface BloggerService extends IService<Blogger> {
    Blogger getBlogger();

    void updateBlogger(Blogger blogger);
}
