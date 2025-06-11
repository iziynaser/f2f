package com.f2f.mapper;

import com.f2f.dto.RoleDTO;
import com.f2f.dbc.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

// RoleMapper.java
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(RoleEntity entity);
    RoleEntity toEntity(RoleDTO dto);
}

