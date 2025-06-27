package com.f2f.dao;

import com.f2f.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ArticleDao")
@Repository
public interface ArticleDao extends CrudRepository<Article,Long> {
}
