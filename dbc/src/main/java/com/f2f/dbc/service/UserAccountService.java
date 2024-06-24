package com.f2f.dbc.service;

import com.f2f.domain.EntityNotFoundException;
import com.f2f.domain.JsonObjects;
import com.f2f.domain.UserAccount;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService extends CommonServiceInterface<UserAccount> {
    JsonObjects<UserAccount> listByUsername(String username,
                                            int pageNum,
                                            int pageSize,
                                            String sortField,
                                            String sortOrder);

    UserAccount findByUsername(String username) throws EntityNotFoundException;

    boolean existsByUsername(String username);

    void loginSuccess(String username) throws EntityNotFoundException;

    void loginFailure(String username);
}
