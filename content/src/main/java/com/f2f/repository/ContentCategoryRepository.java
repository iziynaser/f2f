package com.f2f.repository;

import com.f2f.entity.Content;
import com.f2f.entity.ContentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCategoryRepository extends JpaRepository<ContentCategory, Long> {

    List<ContentCategory> findByContent(Content content);

    List<ContentCategory> findByContentId(Long contentId);

    List<ContentCategory> findByCategoryId(Long categoryId);

    boolean existsByContentIdAndCategoryId(Long contentId, Long categoryId);

    void deleteByContentIdAndCategoryId(Long contentId, Long categoryId);
}
