package ir.verjik.dao;

import ir.verjik.entity.other.EmailAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAdressRepository extends JpaRepository<EmailAddressEntity,Long> {

    EmailAddressEntity findAllByPersonId(Integer personId);
    EmailAddressEntity findAllByPersonIdAndEmailAddress(Integer personId,String emailAddress);
}
