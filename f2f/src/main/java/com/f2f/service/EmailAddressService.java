package com.f2f.service;

import com.f2f.entity.EmailAddress;
import com.f2f.persistance.entity.EmailAddressEntity;
import com.f2f.domain.JsonObjects;
import com.f2f.service.CommonServiceInterface;

public interface EmailAddressService extends CommonServiceInterface<EmailAddressEntity> {

    JsonObjects<EmailAddressEntity> listOfEmailsByPersonId(Integer personId) ;
    EmailAddress create(EmailAddress emailAddress);
}
