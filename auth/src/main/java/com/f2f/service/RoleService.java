package com.f2f.sso.server.service;

import com.f2f.dbc.domain.NotImplementException;
import com.f2f.dbc.domain.Role;
import com.f2f.dbc.service.CommonServiceInterface;

public interface RoleService extends CommonServiceInterface<Role> {
    default Role findByRoleName(String roleName) throws NotImplementException {
        throw new NotImplementException();
    }
}
