package com.lzy.sso.service;

import com.lzy.sso.entity.SysUser;

/**
 * @author lzy
 * @date 2019-02-12
 */
public interface UserService {

    SysUser getByUsername(String username);
}
