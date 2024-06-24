package com.f2f.service;

import com.f2f.dbc.service.CommonServiceInterface;
import com.f2f.entity.EmailAddress;
import com.f2f.entity.EmailAddressEntity;
import com.f2f.domain.JsonObjects;

public interface EmailAddressService extends CommonServiceInterface<EmailAddressEntity> {

    JsonObjects<EmailAddressEntity> listOfEmailsByPersonId(Integer personId) ;
    EmailAddress create(EmailAddress emailAddress);
}
