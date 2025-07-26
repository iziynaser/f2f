package com.f2f.repository;

import com.f2f.entity.Content;
import com.f2f.eums.ContentTargetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    boolean existsBySlug(String slug);

    Optional<Content> findBySlug(String slug);

    List<Content> findByLanguage(String language);

    List<Content> findByTitleContainingIgnoreCase(String titlePart);

    Content findFirstByIdAndLanguage(Long id,String language);

    Optional<Content> getContentByCodeAndLanguage(String code , String language);

    Optional<Content> findByTargetIdAndTargetTypeAndLanguage(Long targetId, ContentTargetType targetType, String language);

}
