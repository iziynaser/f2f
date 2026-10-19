package ir.verjik.service;

import ir.verjik.dbc.domain.JsonObjects;
import ir.verjik.dbc.service.CommonServiceInterface;
import ir.verjik.entity.other.EmailAddress;
import ir.verjik.entity.other.EmailAddressEntity;

public interface EmailAddressService extends CommonServiceInterface<EmailAddressEntity> {

    JsonObjects<EmailAddressEntity> listOfEmailsByPersonId(Integer personId) ;
    EmailAddress create(EmailAddress emailAddress);
}
