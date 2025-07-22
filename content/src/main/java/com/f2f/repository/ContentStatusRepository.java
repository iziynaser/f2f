package com.f2f.repository;

import com.f2f.entity.Content;
import com.f2f.entity.ContentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentStatusRepository extends JpaRepository<ContentStatus, Long> {

    List<ContentStatus> findByContent(Content content);

    List<ContentStatus> findByContentId(Long contentId);

    Optional<ContentStatus> findTopByContentIdOrderByModifyDateDesc(Long contentId);
}
