package com.f2f.dbc.service;

import com.f2f.dbc.domain.*;
import com.f2f.dbc.persistence.entity.RoleEntity;
import com.f2f.dbc.persistence.entity.UserAccountEntity;
import com.f2f.dbc.persistence.repository.RoleRepository;
import com.f2f.dbc.persistence.repository.UserAccountRepository;
import com.f2f.dbc.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountDbcService {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    Mapper dozerMapper;

    @Value("${signin.failure.max:5}")
    private int failureMax;

    @Override
    public JsonObjects<UserAccount> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<UserAccount> jsonObjects = new JsonObjects<>();
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<UserAccountEntity> page;
        if (StringUtils.isBlank(username)) {
            page = userAccountRepository.findAll(pageable);
        } else {
            page = userAccountRepository.findByUsernameLike(username + "%", pageable);
        }
        if (page.getContent() != null && page.getContent().size() > 0) {
            jsonObjects.setRecordsTotal(page.getTotalElements());
            jsonObjects.setRecordsFiltered(page.getTotalElements());
            //page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, UserAccount.class)));
            page.getContent().forEach(u -> jsonObjects.getData().add(copy(u)));
        }
        return jsonObjects;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserAccount create(UserAccount userAccount) throws AlreadyExistsException {
        UserAccountEntity exist = userAccountRepository.findByUsername(userAccount.getUsername());
        if (exist != null) {
            throw new AlreadyExistsException(userAccount.getUsername() + " already exists!");
        }
        //UserAccountEntity userAccountEntity = dozerMapper.map(userAccount, UserAccountEntity.class);
        UserAccountEntity userAccountEntity = copy(userAccount);
        userAccountEntity.getRoles().clear();
        if (userAccount.getRoles() != null && userAccount.getRoles().size() > 0) {
            userAccount.getRoles().forEach(e -> {
                if(e!=null){
                    RoleEntity roleEntity = roleRepository.findByRoleName(e.getRoleName());
                    if (roleEntity != null) {
                        userAccountEntity.getRoles().add(roleEntity);
                    }
                }
            });
        }
        userAccountRepository.save(userAccountEntity);
        //return dozerMapper.map(userAccountEntity, UserAccount.class);
        return copy(userAccountEntity);
    }

    public UserAccountEntity copy(UserAccount ua){
        UserAccountEntity uae = new UserAccountEntity();
        uae.setUsername(ua.getUsername());
        uae.setPassword(ua.getPassword());
        uae.setAccountOpenCode(ua.getAccountOpenCode());
        uae.setNickName(ua.getNickName());
        uae.setAvatarUrl(ua.getAvatarUrl());
        uae.setEmail(ua.getEmail());
        uae.setMobile(ua.getMobile());
        uae.setProvince(ua.getProvince());
        uae.setCity(ua.getCity());
        uae.setAddress(ua.getAddress());
        uae.setBirthday(ua.getBirthday());
        uae.setGender(ua.getGender());
        uae.setFailureTime(ua.getFailureTime());
        uae.setFailureCount(ua.getFailureCount());
        uae.setRoles(copyRoles(ua.getRoles()));
        return uae;
    }

    public UserAccount copy(UserAccountEntity uae){
         UserAccount ua = new UserAccount();
         ua.setUsername(uae.getUsername());
         ua.setPassword(uae.getPassword());
         ua.setAccountOpenCode(uae.getAccountOpenCode());
         ua.setNickName(uae.getNickName());
         ua.setAvatarUrl(uae.getAvatarUrl());
         ua.setEmail(uae.getEmail());
         ua.setMobile(uae.getMobile());
         ua.setProvince(uae.getProvince());
         ua.setCity(uae.getCity());
         ua.setAddress(uae.getAddress());
         ua.setBirthday(uae.getBirthday());
         ua.setGender(uae.getGender());
         ua.setFailureTime(uae.getFailureTime());
         ua.setFailureCount(uae.getFailureCount());
         ua.setRoles(copyRoleEntities(uae.getRoles())); ;
         return ua;
    }

    public List<RoleEntity> copyRoles(List<Role> list){
        List<RoleEntity> roles = new ArrayList<RoleEntity>();
        for(int i=0;i<roles.size();i++){
            roles.add(new RoleEntity(roles.get(i).getRoleName()));
        }
        return roles;
    }
    public List<Role> copyRoleEntities(List<RoleEntity> roleEntities){
        List<Role> roles = new ArrayList<Role>();
        for(int i=0;i<roleEntities.size();i++)
            roles.add(new Role(roleEntities.get(i).getRoleName()));
        return roles;
    }

    @Override
    public UserAccount retrieveById(long id) throws EntityNotFoundException {
        Optional<UserAccountEntity> entityOptional = userAccountRepository.findById(id);
        //return dozerMapper.map(entityOptional.orElseThrow(EntityNotFoundException::new), UserAccount.class);
        UserAccount ua = copy(entityOptional.orElseThrow(EntityNotFoundException::new));
        return ua;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserAccount updateById(UserAccount userAccount) throws EntityNotFoundException {
        Optional<UserAccountEntity> entityOptional = userAccountRepository.findById(Long.parseLong(userAccount.getId()));
        UserAccountEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        if (StringUtils.isNotEmpty(userAccount.getPassword())) {
            e.setPassword(userAccount.getPassword());
        }
        e.setNickName(userAccount.getNickName());
        e.setBirthday(userAccount.getBirthday());
        e.setMobile(userAccount.getMobile());
        e.setProvince(userAccount.getProvince());
        e.setCity(userAccount.getCity());
        e.setAddress(userAccount.getAddress());
        e.setAvatarUrl(userAccount.getAvatarUrl());
        e.setEmail(userAccount.getEmail());

        userAccountRepository.save(e);
        //return dozerMapper.map(e, UserAccount.class);
        return copy(e);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRecordStatus(long id, int recordStatus) {
        Optional<UserAccountEntity> entityOptional = userAccountRepository.findById(id);
        UserAccountEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        e.setRecordStatus(recordStatus);
        userAccountRepository.save(e);
    }

    @Override
    public UserAccount findByUsername(String username) throws EntityNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username);
        if (userAccountEntity != null) {
            //return dozerMapper.map(userAccountEntity, UserAccount.class);
            return copy(userAccountEntity);
        } else {
            throw new EntityNotFoundException(username + " not found!");
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return userAccountRepository.existsByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void loginSuccess(String username) throws EntityNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username);
        if (userAccountEntity != null) {
            userAccountEntity.setFailureCount(0);
            userAccountEntity.setFailureTime(null);
            userAccountRepository.save(userAccountEntity);
        } else {
            throw new EntityNotFoundException(username + " not found!");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void loginFailure(String username) {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username);
        if (userAccountEntity != null) {
            if (userAccountEntity.getFailureTime() == null) {
                userAccountEntity.setFailureCount(1);
            } else {
                if (DateUtil.beforeToday(userAccountEntity.getFailureTime())) {
                    userAccountEntity.setFailureCount(0);
                } else {
                    userAccountEntity.setFailureCount(userAccountEntity.getFailureCount() + 1);
                }
            }
            userAccountEntity.setFailureTime(LocalDateTime.now());
            if (userAccountEntity.getFailureCount() >= failureMax && userAccountEntity.getRecordStatus() >= 0) {
                userAccountEntity.setRecordStatus(-1);
            }
            userAccountRepository.save(userAccountEntity);
        }
    }
}
