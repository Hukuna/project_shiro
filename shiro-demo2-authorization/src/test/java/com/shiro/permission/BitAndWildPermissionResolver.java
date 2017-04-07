package com.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by zxvf on 2017/4/7.
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

    public Permission resolvePermission(String s) {
        if (s.startsWith("+")){
            return new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
