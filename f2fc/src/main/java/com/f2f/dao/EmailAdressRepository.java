package com.f2f.dao;

import com.f2f.entity.EmailAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAdressRepository extends JpaRepository<EmailAddressEntity,Long> {

    EmailAddressEntity findAllByPersonId(Integer personId);
    EmailAddressEntity findAllByPersonIdAndEmailAddress(Integer personId,String emailAddress);
}
