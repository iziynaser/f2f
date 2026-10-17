package ir.verjik.repository;

import ir.verjik.entity.QaTarget;
import ir.verjik.enums.QaTargetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QaTargetRepository extends JpaRepository<QaTarget, Long> {

    Optional<QaTarget> findByTargetTypeAndTargetId(QaTargetType targetType, Long targetId);
}
