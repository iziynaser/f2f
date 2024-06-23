package com.f2f.sso.server.service;

//import com.revengemission.sso.oauth2.server.domain.NotImplementException;
//import com.revengemission.sso.oauth2.server.domain.Role;

import com.f2f.dbc.service.CommonServiceInterface;
import com.f2f.domain.NotImplementException;
import com.f2f.domain.Role;

public interface RoleService extends CommonServiceInterface<Role> {
    default Role findByRoleName(String roleName) throws NotImplementException {
        throw new NotImplementException();
    }
}
