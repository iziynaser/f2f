package com.f2f.service;

import com.f2f.dbc.domain.JsonObjects;
import com.f2f.dbc.service.CommonServiceInterface;
import com.f2f.entity.EmailAddress;
import com.f2f.entity.EmailAddressEntity;

public interface EmailAddressService extends CommonServiceInterface<EmailAddressEntity> {

    JsonObjects<EmailAddressEntity> listOfEmailsByPersonId(Integer personId) ;
    EmailAddress create(EmailAddress emailAddress);
}
