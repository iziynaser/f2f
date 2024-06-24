package com.f2f.dao;

import com.f2f.entity.EmailTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailTypeRepositort extends JpaRepository<EmailTypeEntity,Long> {

    List<EmailTypeEntity> findAll();
}
