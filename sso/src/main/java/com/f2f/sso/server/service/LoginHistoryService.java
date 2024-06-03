package com.f2f.sso.server.service;

//import com.revengemission.sso.oauth2.server.domain.JsonObjects;
//import com.revengemission.sso.oauth2.server.domain.LoginHistory;

import com.f2f.domain.JsonObjects;
import com.f2f.domain.LoginHistory;

public interface LoginHistoryService extends CommonServiceInterface<LoginHistory> {
    JsonObjects<LoginHistory> listByUsername(String username, int pageNum,
                                             int pageSize,
                                             String sortField,
                                             String sortOrder);
    
    void asyncCreate(LoginHistory loginHistory);

}
