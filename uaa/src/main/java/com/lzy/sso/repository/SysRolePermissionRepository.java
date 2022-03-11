package com.lzy.sso.repository;

import com.lzy.sso.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lzy
 * @date 2019-02-12
 */
public interface SysRolePermissionRepository extends JpaSpecificationExecutor<SysRolePermission>, JpaRepository<SysRolePermission, Integer> {

    @Query(value = "SELECT * FROM sys_role_permission WHERE role_id IN (:roleIds)", nativeQuery = true)
    List<SysRolePermission> findByRoleIds(@Param("roleIds") List<Integer> roleIds);
}
