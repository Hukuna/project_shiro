package com.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zxvf on 2017/4/7.
 */
public class MyRolePermissionResolver implements RolePermissionResolver {

    public Collection<Permission> resolvePermissionsInRole(String s) {
        if ("role1".equals(s)){
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));
        }
        return null;
    }
}
