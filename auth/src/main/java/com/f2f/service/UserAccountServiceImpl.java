package com.f2f.service;

import com.f2f.dbc.domain.*;
import com.f2f.dbc.persistence.entity.RoleEntity;
import com.f2f.dto.RoleDTO;
import com.f2f.dto.UserAccountDTO;
import com.f2f.dbc.util.DateUtil;
import com.f2f.entity.UserAccountEntity;
import com.f2f.repository.RoleRepository;
import com.f2f.repository.UserAccountRepository;
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
import java.util.*;

@Service
public class UserAccountServiceImpl implements UserAccountDbcService {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    RoleRepository roleRepository;

    @Value("${signin.failure.max:5}")
    private int failureMax;

    public JsonObjects<UserAccountDTO> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<UserAccountDTO> jsonObjects = new JsonObjects<>();
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

    @Transactional(rollbackFor = Exception.class)
    public UserAccountDTO create(UserAccountDTO userAccount) throws AlreadyExistsException {
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
                    Optional<RoleEntity> roleEntity = roleRepository.findByRoleName(e.getRoleName());
                    if (roleEntity.isPresent()) {
                        userAccountEntity.getRoles().add(roleEntity.get());
                    }
                }
            });
        }
        userAccountRepository.save(userAccountEntity);
        //return dozerMapper.map(userAccountEntity, UserAccount.class);
        return copy(userAccountEntity);
    }

    public UserAccountEntity copy(UserAccountDTO ua){
        UserAccountEntity uae = new UserAccountEntity();
        uae.setUsername(ua.getUsername());
        uae.setPassword(ua.getPassword());

        //uae.setAccountOpenCode(ua.getAccountOpenCode());
        //uae.setNickName(ua.getNickName());
        //uae.setAvatarUrl(ua.getAvatarUrl());
        //uae.setEmail(ua.getEmail());
        //uae.setMobile(ua.getMobile());
        //uae.setProvince(ua.getProvince());
        //uae.setCity(ua.getCity());
        //uae.setAddress(ua.getAddress());
        //uae.setBirthday(ua.getBirthday());
        //uae.setGender(ua.getGender());
        //uae.setFailureTime(ua.getFailureTime());
        //uae.setFailureCount(ua.getFailureCount());

        uae.setRoles(copyRoles(ua.getRoles()));
        return uae;
    }

    public UserAccountDTO copy(UserAccountEntity uae){
         UserAccountDTO ua = new UserAccountDTO();
         ua.setUsername(uae.getUsername());
         ua.setPassword(uae.getPassword());
//         ua.setAccountOpenCode(uae.getAccountOpenCode());
//         ua.setNickName(uae.getNickName());
//         ua.setAvatarUrl(uae.getAvatarUrl());
//         ua.setEmail(uae.getEmail());
//         ua.setMobile(uae.getMobile());
//         ua.setProvince(uae.getProvince());
//         ua.setCity(uae.getCity());
//         ua.setAddress(uae.getAddress());
//         ua.setBirthday(uae.getBirthday());
//         ua.setGender(uae.getGender());
//         ua.setFailureTime(uae.getFailureTime());
//         ua.setFailureCount(uae.getFailureCount());
//         ua.setRoles(copyRoleEntities(uae.getRoles())); ;
         return ua;
    }

    public Set<RoleEntity> copyRoles(Set<RoleDTO> list){
        Set<RoleEntity> roles = new HashSet<>();
//        for(int i=0;i<roles.size();i++){
//            roles.add(new RoleEntity(roles.get(i).getRoleName()));
//        }
        return roles;
    }
    public List<Role> copyRoleEntities(List<RoleEntity> roleEntities){
        List<Role> roles = new ArrayList<Role>();
        for(int i=0;i<roleEntities.size();i++)
            roles.add(new Role(roleEntities.get(i).getRoleName()));
        return roles;
    }

    public UserAccountDTO retrieveById(long id) throws EntityNotFoundException {
        Optional<UserAccountEntity> entityOptional = userAccountRepository.findById(id);
        //return dozerMapper.map(entityOptional.orElseThrow(EntityNotFoundException::new), UserAccount.class);
        UserAccountDTO ua = copy(entityOptional.orElseThrow(EntityNotFoundException::new));
        return ua;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserAccountDTO updateById(UserAccountDTO userAccount) throws EntityNotFoundException {
        Optional<UserAccountEntity> entityOptional = userAccountRepository.findById(userAccount.getId());
        UserAccountEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        if (StringUtils.isNotEmpty(userAccount.getPassword())) {
            e.setPassword(userAccount.getPassword());
        }

        //e.setNickName(userAccount.getNickName());
        //e.setBirthday(userAccount.getBirthday());
        //e.setMobile(userAccount.getMobile());
        //e.setProvince(userAccount.getProvince());
        //e.setCity(userAccount.getCity());
        //e.setAddress(userAccount.getAddress());
        //e.setAvatarUrl(userAccount.getAvatarUrl());
        //e.setEmail(userAccount.getEmail());

        userAccountRepository.save(e);
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


    public UserAccountDTO findByUsername(String username) throws EntityNotFoundException {
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

    @Override
    public UserAccountDTO createGuestUserAccount() {
        return null;
    }
}
