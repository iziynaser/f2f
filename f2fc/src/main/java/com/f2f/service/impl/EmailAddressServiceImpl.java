package com.f2f.service.impl;

import com.f2f.entity.EmailAddress;
import com.f2f.persistance.entity.EmailAddressEntity;
import com.f2f.persistance.repository.EmailAdressRepository;
import com.f2f.service.EmailAddressService;
import com.f2f.domain.AlreadyExistsException;
import com.f2f.domain.JsonObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.dozermapper.core.*;

@Service
public class EmailAddressServiceImpl implements EmailAddressService {
//
    @Autowired
EmailAdressRepository emailAdressRepository;

    @Autowired
    Mapper dozerMapper;

    @Override
    public JsonObjects<EmailAddressEntity> listOfEmailsByPersonId(Integer personId) {
        return null;
    }
//
//    @Transactional(rollbackFor = Exception.class)
    public EmailAddress create(EmailAddress emailAddress)throws AlreadyExistsException {
        String address = emailAddress.getAddress();
        Integer personId = emailAddress.getPersonId();
        EmailAddressEntity emailAddressEntityExist = emailAdressRepository.findAllByPersonIdAndEmailAddress(personId,address);
        if(emailAddressEntityExist !=null){
            throw new AlreadyExistsException("emailAddress :"+address+" for user :"+personId +" already exist");
        }

        EmailAddressEntity emailAddressEntity = dozerMapper.map(emailAddress,EmailAddressEntity.class);
        emailAdressRepository.save(emailAddressEntity);
        return dozerMapper.map(emailAddressEntity,EmailAddress.class);
    }
}
