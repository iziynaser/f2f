package com.f2f.repository;

import com.f2f.entity.QaTarget;
import com.f2f.enums.QaTargetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QaTargetRepository extends JpaRepository<QaTarget, Long> {

    QaTarget findByTargetTypeAndTargetId(QaTargetType targetType, Long targetId);
}
