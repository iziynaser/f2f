package com.f2f.sso.server.service.impl;

import com.f2f.domain.AlreadyExistsException;
import com.f2f.domain.EntityNotFoundException;
import com.f2f.domain.JsonObjects;
import com.f2f.domain.OauthClient;
import com.f2f.persistence.entity.OauthClientEntity;
import com.f2f.persistence.repository.OauthClientRepository;
import com.f2f.sso.server.service.OauthClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired
    OauthClientRepository oauthClientRepository;

//    @Autowired
//    Mapper dozerMapper;

    public OauthClient copy(OauthClientEntity oauthClientEntity){
        OauthClient oauthClient = new OauthClient();
        oauthClient.setClientId(oauthClientEntity.getClientId());
        oauthClient.setApplicationName(oauthClientEntity.getApplicationName());
        oauthClient.setResourceIds(oauthClientEntity.getResourceIds());
        oauthClient.setClientSecret(oauthClientEntity.getClientSecret());
        oauthClient.setScope(oauthClientEntity.getScope());
        oauthClient.setAuthorizedGrantTypes(oauthClientEntity.getAuthorizedGrantTypes());
        oauthClient.setWebServerRedirectUri(oauthClientEntity.getWebServerRedirectUri());
        oauthClient.setAuthorities(oauthClientEntity.getAuthorities());
        oauthClient.setAccessTokenValidity(oauthClientEntity.getAccessTokenValidity());
        oauthClient.setRefreshTokenValidity(oauthClientEntity.getRefreshTokenValidity());
        oauthClient.setAdditionalInformation(oauthClientEntity.getAdditionalInformation());
        oauthClient.setAutoApprove(oauthClientEntity.getAutoApprove());
        oauthClient.setExpirationDate(oauthClientEntity.getExpirationDate());
        return oauthClient;
    }

    public OauthClientEntity copy(OauthClient oauthClient){
        OauthClientEntity oauthClientEntity = new OauthClientEntity();
        oauthClientEntity.setClientId(oauthClient.getClientId());
        oauthClientEntity.setApplicationName(oauthClient.getApplicationName());
        oauthClientEntity.setResourceIds(oauthClient.getResourceIds());
        oauthClientEntity.setClientSecret(oauthClient.getClientSecret());
        oauthClientEntity.setScope(oauthClient.getScope());
        oauthClientEntity.setAuthorizedGrantTypes(oauthClient.getAuthorizedGrantTypes());
        oauthClientEntity.setWebServerRedirectUri(oauthClient.getWebServerRedirectUri());
        oauthClientEntity.setAuthorities(oauthClient.getAuthorities());
        oauthClientEntity.setAccessTokenValidity(oauthClient.getAccessTokenValidity());
        oauthClientEntity.setRefreshTokenValidity(oauthClient.getRefreshTokenValidity());
        oauthClientEntity.setAdditionalInformation(oauthClient.getAdditionalInformation());
        oauthClientEntity.setAutoApprove(oauthClient.getAutoApprove());
        oauthClientEntity.setExpirationDate(oauthClient.getExpirationDate());
        return oauthClientEntity;
    }

    @Override
    public OauthClient findByClientId(String clientId) {
        OauthClientEntity oauthClientEntity = oauthClientRepository.findByClientId(clientId);
        if (oauthClientEntity != null) {
            //return dozerMapper.map(oauthClientEntity, OauthClient.class);
            return copy(oauthClientEntity);
        } else {
            return null;
        }
    }

    @Override
    public JsonObjects<OauthClient> list(int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<OauthClient> jsonObjects = new JsonObjects<OauthClient>();
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<OauthClientEntity> page = oauthClientRepository.findAll(pageable);
        if (page.getContent() != null && page.getContent().size() > 0) {
            jsonObjects.setRecordsTotal(page.getTotalElements());
            jsonObjects.setRecordsFiltered(page.getTotalElements());
            //page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, OauthClient.class)));
            page.getContent().forEach(u -> jsonObjects.getData().add(copy(u)));
        }
        return jsonObjects;
    }

    @Override
    public OauthClient create(OauthClient oauthClient) throws AlreadyExistsException {
        OauthClientEntity exist = oauthClientRepository.findByClientId(oauthClient.getClientId());
        if (exist != null) {
            throw new AlreadyExistsException(oauthClient.getClientId() + " already exists!");
        }
        //OauthClientEntity oauthClientEntity = dozerMapper.map(oauthClient, OauthClientEntity.class);
        OauthClientEntity oauthClientEntity = copy(oauthClient);
        oauthClientRepository.save(oauthClientEntity);
        //return dozerMapper.map(oauthClientEntity, OauthClient.class);
        return copy(oauthClientEntity);
    }

    @Override
    public OauthClient retrieveById(long id) throws EntityNotFoundException {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(id);
        //return dozerMapper.map(entityOptional.orElseThrow(EntityNotFoundException::new), OauthClient.class);
        OauthClientEntity  oe = entityOptional.orElseThrow(EntityNotFoundException::new);
        return copy(oe);
    }

    @Override
    public OauthClient updateById(OauthClient oauthClient) throws EntityNotFoundException {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(Long.parseLong(oauthClient.getId()));
        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        if (StringUtils.isNotEmpty(oauthClient.getClientSecret())) {
            e.setClientSecret(oauthClient.getClientSecret());
        }
        e.setAuthorities(oauthClient.getAuthorities());
        e.setScope(oauthClient.getScope());
        e.setAuthorizedGrantTypes(oauthClient.getAuthorizedGrantTypes());
        e.setWebServerRedirectUri(oauthClient.getWebServerRedirectUri());

        if (StringUtils.isNotEmpty(oauthClient.getRemarks())) {
            e.setRemarks(oauthClient.getRemarks());
        }

        oauthClientRepository.save(e);
        //return dozerMapper.map(e, OauthClient.class);
        return copy(e);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRecordStatus(long id, int recordStatus) {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(id);
        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        e.setRecordStatus(recordStatus);
        oauthClientRepository.save(e);
    }
}
