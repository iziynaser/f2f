package com.f2f.persistance.repository;

import com.f2f.persistance.entity.EmailTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailTypeRepositort extends JpaRepository<EmailTypeEntity,Long> {

    List<EmailTypeEntity> findAll();
}
