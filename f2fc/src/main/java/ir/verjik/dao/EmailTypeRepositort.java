package ir.verjik.dao;

import ir.verjik.entity.other.EmailTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailTypeRepositort extends JpaRepository<EmailTypeEntity,Long> {

    List<EmailTypeEntity> findAll();
}
