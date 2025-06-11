package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountDTO {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private Boolean expired;
    private LocalDateTime expireDate;
    private String locale;
    private String passwordHint;
    private Boolean requirePasswordChange;
    private Long personId;
    private Set<RoleDTO> roles;
}
