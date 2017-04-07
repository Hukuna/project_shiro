package com.shiro.demo2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zxvf on 2017/4/7.
 */
public class PermissionTest extends BaseTest {

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-permission.ini","zhang","123");
        //判断拥有权限 user:delete
        Assert.assertTrue(subject().isPermitted("user:delete"));
        //判断拥有角色 user:create,user:delete
        Assert.assertTrue(subject().isPermittedAll("user:create","user:delete"));
    }
}
