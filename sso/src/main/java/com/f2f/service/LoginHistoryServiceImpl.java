package com.f2f.service;

import com.f2f.dbc.domain.AlreadyExistsException;
import com.f2f.dbc.domain.JsonObjects;
import com.f2f.dbc.domain.LoginHistory;
import com.f2f.entity.LoginHistoryEntity;
import com.f2f.repository.LoginHistoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Autowired
    LoginHistoryRepository loginHistoryRepository;

//    @Autowired
//    Mapper dozerMapper;

    @Override
    public JsonObjects<LoginHistory> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<LoginHistory> jsonObjects = new JsonObjects<>();
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<LoginHistoryEntity> page = loginHistoryRepository.findByUsername(username, pageable);
        if (page.getContent() != null && page.getContent().size() > 0) {
            jsonObjects.setRecordsTotal(page.getTotalElements());
            jsonObjects.setRecordsFiltered(page.getTotalElements());
            //page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, LoginHistory.class)));
            page.getContent().forEach(u -> jsonObjects.getData().add(copy(u)));
        }
        return jsonObjects;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void asyncCreate(LoginHistory loginHistory) throws AlreadyExistsException {
        //LoginHistoryEntity entity = dozerMapper.map(loginHistory, LoginHistoryEntity.class);
        LoginHistoryEntity entity = copy(loginHistory);
        loginHistoryRepository.save(entity);
    }

    public LoginHistoryEntity copy(LoginHistory loginHistory){
        LoginHistoryEntity loginHistoryEntity = new LoginHistoryEntity();
        loginHistoryEntity.setClientId(loginHistory.getClientId());
        loginHistoryEntity.setUsername(loginHistory.getUsername());
        loginHistoryEntity.setIpAddress(loginHistory.getIp());
        loginHistoryEntity.setDevice(loginHistory.getDevice());
        return loginHistoryEntity;
    }

    public LoginHistory copy(LoginHistoryEntity loginHistoryEntity){
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setClientId(loginHistoryEntity.getClientId());
        loginHistory.setUsername(loginHistoryEntity.getUsername());
        loginHistory.setIp(loginHistoryEntity.getIpAddress());
        loginHistory.setDevice(loginHistoryEntity.getDevice());
        return loginHistory;
    }
}
