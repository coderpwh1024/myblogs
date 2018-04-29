package com.itzixi.authenticator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author coderpwh
 * @Date: 2018/4/25.
 * @Description:
 */

public class ShiroLoginTest {


    public void testSubjectLoginAndLogout() {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config/userInfo.ini");

        // 创建安全管理者
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        // 获取主体信息
        Subject subject = SecurityUtils.getSubject();

        // 创建用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken("lucy", "test1002");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        boolean isLogin = subject.isAuthenticated();
        System.out.println("主体/用户 的登录状态为:" + isLogin);


         // 退出
        subject.logout();
        isLogin = subject.isAuthenticated();
        System.out.println("主体/用户 的登录状态为:" + isLogin);

    }


    public void testSubjectShiroRealm() {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config/shiroDBRealm.ini");

        // 安全管理者
        SecurityManager securityManager = factory.getInstance();

        // 设置当前环境，使用securityManager
        SecurityUtils.setSecurityManager(securityManager);

        // 获取主体信息
        Subject subject = SecurityUtils.getSubject();

        // 用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken("lucy", "test1002");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//		new ShiroLoginTest().testSubjectLoginAndLogout();
        new ShiroLoginTest().testSubjectShiroRealm();
    }


}
