package com.dylan.rbac.server.service.auth;


import com.dylan.rbac.api.auth.RoleService;
import com.dylan.rbac.common.serviceImpl.BaseServiceImpl;
import com.dylan.rbac.dao.auth.RoleMapper;
import com.dylan.rbac.data.model.auth.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleMapper, Long> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleMapper getMapper() {
        return this.roleMapper;
    }

    @Override
    public Long getPrimaryKey(Role obj) {
        return obj.getId();
    }




}
