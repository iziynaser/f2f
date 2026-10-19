package ir.verjik.service.impl;

import ir.verjik.dao.EmailAdressRepository;
import ir.verjik.dbc.domain.AlreadyExistsException;
import ir.verjik.dbc.domain.JsonObjects;
import ir.verjik.entity.other.EmailAddress;
import ir.verjik.entity.other.EmailAddressEntity;
import ir.verjik.service.EmailAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailAddressServiceImpl implements EmailAddressService {
//
    @Autowired
EmailAdressRepository emailAdressRepository;

//    @Autowired
//    Mapper dozerMapper;

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

        //EmailAddressEntity emailAddressEntity = dozerMapper.map(emailAddress,EmailAddressEntity.class);
        EmailAddressEntity emailAddressEntity = copy(emailAddress);
        emailAdressRepository.save(emailAddressEntity);
        //return dozerMapper.map(emailAddressEntity,EmailAddress.class);
        return copy(emailAddressEntity);
    }

    public EmailAddress copy(EmailAddressEntity emailAddressEntity ){
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setPersonId(emailAddressEntity.getPersonId());
        emailAddress.setAddress(emailAddressEntity.getEmailAddress());
        emailAddress.setFullName(emailAddressEntity.getFullName());
        emailAddress.setAddressType(emailAddressEntity.getAddressType());
        return emailAddress;
    }

    public EmailAddressEntity copy(EmailAddress emailAddress){
        EmailAddressEntity emailAddressEntity = new EmailAddressEntity();
        emailAddressEntity.setPersonId(emailAddress.getPersonId());
        emailAddressEntity.setEmailAddress(emailAddress.getAddress());
        emailAddressEntity.setFullName(emailAddress.getFullName());
        emailAddressEntity.setAddressType(emailAddress.getAddressType());
        return emailAddressEntity;
    }
}
