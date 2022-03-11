package com.lzy.sso.service;

import com.lzy.sso.entity.SysPermission;

import java.util.List;

/**
 * @author lzy
 * @date 2019-02-12
 */
public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}
