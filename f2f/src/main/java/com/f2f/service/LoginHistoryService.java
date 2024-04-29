package com.f2f.service;

import com.f2f.domain.*;

public interface LoginHistoryService extends CommonServiceInterface<LoginHistory> {
    JsonObjects<LoginHistory> listByUsername(String username, int pageNum,
                                             int pageSize,
                                             String sortField,
                                             String sortOrder);

    void asyncCreate(LoginHistory loginHistory);

}
