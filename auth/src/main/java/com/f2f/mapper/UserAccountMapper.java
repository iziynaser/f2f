package com.f2f.mapper;

import com.f2f.dto.UserAccountDTO;
import com.f2f.entity.UserAccountEntity;
import org.mapstruct.Mapper;

// UserAccountMapper.java
@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserAccountMapper {
    UserAccountDTO toDTO(UserAccountEntity entity);
    UserAccountEntity toEntity(UserAccountDTO dto);
}
