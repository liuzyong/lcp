package com.lzy.sso.vo;

import com.lzy.sso.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author lzy
 * @date 2019-02-12
 */
@Data
public class SysUserVO extends SysUser {

    /**
     * 权限列表
     */
    private List<String> authorityList;

}
