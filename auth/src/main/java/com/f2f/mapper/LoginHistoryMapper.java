package com.f2f.mapper;

import com.f2f.dto.LoginHistoryDTO;
import com.f2f.persisence.LoginHistoryEntity;
import org.mapstruct.Mapper;

// LoginHistoryMapper.java
@Mapper(componentModel = "spring")
public interface LoginHistoryMapper {
//    @Mapping(source = "user.id", target = "userId")
    LoginHistoryDTO toDTO(LoginHistoryEntity entity);

//    @Mapping(source = "userId", target = "user.id")
    LoginHistoryEntity toEntity(LoginHistoryDTO dto);
}

