package com.shiro.demo2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zxvf on 2017/4/7.
 */
public class AuthorizerTest extends BaseTest {

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-authorizer.ini","zhang","123");
        //1、判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user1:create"));
    }

    @Test
    public void testIsPermitted2(){
        login("classpath:shiro-authorizer.ini","zhang","123");
        Assert.assertTrue(subject().isPermitted("user1:create"));
        //通过二进制位的方式表示权限
        Assert.assertTrue(subject().isPermitted("+user1+2"));//新增权限
        Assert.assertTrue(subject().isPermitted("+user1+8"));//查看权限
        Assert.assertTrue(subject().isPermitted("+user2+10"));//新增及查看

        Assert.assertFalse(subject().isPermitted("+user1+4"));//没有删除权限

        Assert.assertTrue(subject().isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
    }
}
