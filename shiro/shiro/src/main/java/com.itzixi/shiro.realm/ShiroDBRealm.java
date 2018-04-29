package com.itzixi.shiro.realm;

import com.itzixi.pojo.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import java.util.ArrayList;
import java.util.List;


/**
 * @author coderpwh
 * @Date: 2018/4/25.
 * @Description:
 */
public class ShiroDBRealm extends AuthorizingRealm {


    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        String  username = userToken.getUsername();
        String password = String.valueOf(userToken.getPassword());

        SysUser user  = new SysUser();
        user.setUsername("jack");
        user.setPassword("239577105576af094665bc75d02ee876");
        user.setAuthSalt("abcd");

         if(user==null){
             return  null;
         }
         String dbPassword = user.getPassword();
         String dbSalt = user.getAuthSalt();
         String userPassword = new Md5Hash(password,dbSalt,2).toString();

         if(!userPassword.equals(dbPassword)){
             throw  new IncorrectCredentialsException();
         }

        AuthenticationInfo info = new SimpleAuthenticationInfo(user,password.toCharArray(),getName());

        return info;
    }

    /**
     * 授权鉴权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


       SysUser sessionUser = (SysUser) principals.getPrimaryPrincipal();


        // 此处应从数据库获取
        List<String> permissionList = new ArrayList<String>();
        permissionList.add("user:add");
        permissionList.add("user:del");
        permissionList.add("user:mod");
        permissionList.add("dept:queryall");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(String.valueOf(permissionList));

        return simpleAuthorizationInfo;
    }
}
