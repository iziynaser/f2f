package com.f2f.dbc.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.domain.JsonObjects;
import com.f2f.dbc.domain.UserAccount;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountDbcService extends CommonServiceInterface<UserAccount> {
    JsonObjects<UserAccount> listByUsername(String username,
                                            int pageNum,
                                            int pageSize,
                                            String sortField,
                                            String sortOrder);

    UserAccount findByUsername(String username) throws EntityNotFoundException;

    boolean existsByUsername(String username);

    void loginSuccess(String username) throws EntityNotFoundException;

    void loginFailure(String username);

    UserAccount createGuestUserAccount();
}
