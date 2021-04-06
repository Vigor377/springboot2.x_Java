package com.chen.pei.config.shiro;

import com.chen.pei.entity.Blogger;
import com.chen.pei.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了==授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Blogger blogger = loginService.findLoginByName(token.getUsername());
        if(blogger == null){
            return null;  //return null 会报login方法的具体异常
        }
        return new SimpleAuthenticationInfo(blogger,blogger.getPassword(),"");  //密码比较
    }
}
