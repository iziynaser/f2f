package com.f2f.service;

import com.f2f.dbc.domain.NotImplementException;
import com.f2f.dbc.domain.Role;
import com.f2f.entity.RoleEntity;
import com.f2f.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    Mapper dozerMapper;

    @Override
    public Role findByRoleName(String roleName) throws NotImplementException {
        Optional<RoleEntity> roleEntity = roleRepository.findByRoleName(roleName);
        if (roleEntity.isPresent()) {
            //return dozerMapper.map(roleEntity, Role.class);
            return copy(roleEntity.orElse(null));
        } else {
            return null;
        }
    }

    public Role copy(RoleEntity roleEntity){
        Role r = new Role();
        r.setRoleName(roleEntity.getRoleName());
        return r;
    }
}
