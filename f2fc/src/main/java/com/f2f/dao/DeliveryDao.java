package com.f2f.dao;

import com.f2f.entity.Delivery;
import com.f2f.persistence.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("DeliveryDao")
@Repository
public interface DeliveryDao extends CrudRepository<Delivery,Long> {

    Iterable<Delivery> findAllByUserAccountEntity(UserAccountEntity userAccountEntity);

    Delivery findFirstByUserAccountEntityOrderByDateCreated(UserAccountEntity userAccountEntity);

    Delivery findFirstById(Long id);
}
