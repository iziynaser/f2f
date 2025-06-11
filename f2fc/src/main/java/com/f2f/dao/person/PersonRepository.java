package com.f2f.dao.person;

import com.f2f.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    // می‌توان متدهای سفارشی اضافه کرد
}
