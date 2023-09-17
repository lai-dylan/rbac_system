package com.dylan.rbac.dao.auth;

import com.dylan.rbac.common.mapper.BaseMapper;
import com.dylan.rbac.data.model.auth.UserRole;
import com.dylan.rbac.data.model.auth.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends BaseMapper<UserRole, UserRoleExample, Long> {
    long countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
}