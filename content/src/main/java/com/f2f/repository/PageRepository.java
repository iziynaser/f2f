package com.f2f.repository;

import com.f2f.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    Optional<Page> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Page> findByTitleContainingIgnoreCase(String keyword);

    List<Page> findByLanguage(String language);

    Optional<Page> findByContentIdAndLanguage(Long contentId, String language);

}
