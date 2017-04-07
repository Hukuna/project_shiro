package com.demo1.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zxvf on 2017/4/7.
 */
public class LoginLogoutTest {

    @Test
    public void testHelloworld(){

        //1、获取SecurityManager工厂，这里使用ini配置文件来初始化
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、获取SecurityManager的实例对象，并绑定给SercurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject对象及用户的身份凭证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //4、登录，即验证身份
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、验证失败
            System.out.println("登录失败！");
        }
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();
    }

    @Test
    public void testCustomRealm(){
        //1、获取SecurityManager工厂，这里使用ini配置文件来初始化
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2、获取SecurityManager的实例对象，并绑定给SercurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject对象及用户的身份凭证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //4、登录，即验证身份
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、验证失败
            System.out.println("登录失败！");
        }
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();
    }

    @Test
    public void testJdbcRealm(){
        //1、获取SecurityManager工厂，这里使用ini配置文件来初始化
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、获取SecurityManager的实例对象，并绑定给SercurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject对象及用户的身份凭证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //4、登录，即验证身份
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、验证失败
            System.out.println("登录失败！");
        }
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
