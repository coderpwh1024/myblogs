package com.itzixi.authorizer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coderpwh
 * @Date: 2018/4/25.
 * @Description:
 */
public class ShiroAuthTest {

    public void testUserIniAuthPermission() {

        // 工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config/shiroPermission.ini");

        // 安全管理器
        SecurityManager securityManager = factory.getInstance();

        // 设置当前环境
        SecurityUtils.setSecurityManager(securityManager);

        // 获取主体信息
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("jack", "abc123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // 基于角色的授权
        System.out.println("当前用户是否含有 admin 角色：" + subject.hasRole("admin"));
        System.out.println("当前用户是否含有 coder 角色：" + subject.hasRole("coder"));
        System.out.println("当前用户是否含有 hr 角色：" + subject.hasRole("hr"));

        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("coder");
        roles.add("hr");
        boolean flagRoles[] = subject.hasRoles(roles);
        System.out.println("===============================");
        for (boolean r : flagRoles) {
            System.out.println(r);
        }
        System.out.println("===============================");

        // 基于资源的授权
        System.out.println("当前用户是否含有 user:query 资源：" + subject.isPermitted("user:query"));
        System.out.println("当前用户是否含有 user:add 资源：" + subject.isPermitted("user:add"));
        System.out.println("当前用户是否含有 user:mod 资源：" + subject.isPermitted("user:mod"));
        System.out.println("当前用户是否含有 user:del 资源：" + subject.isPermitted("user:del"));

        boolean flagPermissions[] = subject.isPermitted("user:query", "user:add", "user:mod", "user:del");
        System.out.println("===============================");
        for (boolean p : flagPermissions) {
            System.out.println(p);
        }
        System.out.println("===============================");

    }

    public void testCustomUserAuthPermission() {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config/shiroDBRealm.ini");

        // 安全管理器
        SecurityManager securityManager = factory.getInstance();

        //  设置当前环境
        SecurityUtils.setSecurityManager(securityManager);

        // 获取主体信息
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("jack", "test1001");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println("当前用户是否已经登录认证：" + subject.isAuthenticated());

        System.out.println("当前用户是否含有 user:query 资源：" + subject.isPermitted("user:query"));
        System.out.println("当前用户是否含有 user:add 资源：" + subject.isPermitted("user:add"));
        System.out.println("当前用户是否含有 user:mod 资源：" + subject.isPermitted("user:mod"));
        System.out.println("当前用户是否含有 user:del 资源：" + subject.isPermitted("user:del"));
        System.out.println("当前用户是否含有 dept:queryall 资源：" + subject.isPermitted("dept:queryall"));


    }


    public static void main(String[] args) {
//        new ShiroAuthTest().testUserIniAuthPermission();
        new ShiroAuthTest().testCustomUserAuthPermission();
    }


}
