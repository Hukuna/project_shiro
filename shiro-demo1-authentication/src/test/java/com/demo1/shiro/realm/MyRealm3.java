package com.demo1.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by zxvf on 2017/4/7.
 */
public class MyRealm3 implements Realm{

    public String getName() {
        return "myrealm3";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); //获取用户名
        String password = new String((char[])authenticationToken.getCredentials()); //获取密码
        if (!"zhang".equals(username)){
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        //如果身份验证成功，则返回一个AuthenticationInfo的实现
        return new SimpleAuthenticationInfo(username+"@163.com",password,getName());
    }
}
