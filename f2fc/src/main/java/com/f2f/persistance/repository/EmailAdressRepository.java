package com.f2f.persistance.repository;

import com.f2f.persistance.entity.EmailAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAdressRepository extends JpaRepository<EmailAddressEntity,Long> {

    EmailAddressEntity findAllByPersonId(Integer personId);
    EmailAddressEntity findAllByPersonIdAndEmailAddress(Integer personId,String emailAddress);
}
