package com.f2f.mapper;

import com.f2f.dto.PasswordPolicyDTO;
import com.f2f.entity.PasswordPolicyEntity;
import org.mapstruct.Mapper;

// PasswordPolicyMapper.java
@Mapper(componentModel = "spring")
public interface PasswordPolicyMapper {
    PasswordPolicyDTO toDTO(PasswordPolicyEntity entity);
    PasswordPolicyEntity toEntity(PasswordPolicyDTO dto);
}

