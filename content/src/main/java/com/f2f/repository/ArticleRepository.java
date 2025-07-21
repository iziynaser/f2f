package com.f2f.repository;

import com.f2f.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findBySlug(String slug);

    List<Article> findByAuthorContainingIgnoreCase(String author);

    List<Article> findByPublishDateBefore(LocalDateTime date);
}
