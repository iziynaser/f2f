package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.domain.JsonObjects;
import com.f2f.dto.UserAccountDTO;
import com.f2f.dbc.service.CommonServiceInterface;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountDbcService extends CommonServiceInterface<UserAccountDTO> {
    JsonObjects<UserAccountDTO> listByUsername(String username,
                                            int pageNum,
                                            int pageSize,
                                            String sortField,
                                            String sortOrder);

    UserAccountDTO findByUsername(String username) throws EntityNotFoundException;

    boolean existsByUsername(String username);

    void loginSuccess(String username) throws EntityNotFoundException;

    void loginFailure(String username);

    UserAccountDTO createGuestUserAccount();
}
