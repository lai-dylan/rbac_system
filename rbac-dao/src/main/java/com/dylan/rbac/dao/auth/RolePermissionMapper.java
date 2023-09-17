package com.dylan.rbac.dao.auth;

import com.dylan.rbac.common.mapper.BaseMapper;
import com.dylan.rbac.data.model.auth.RolePermission;
import com.dylan.rbac.data.model.auth.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper extends BaseMapper<RolePermission, RolePermissionExample, Long> {
    long countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);
}