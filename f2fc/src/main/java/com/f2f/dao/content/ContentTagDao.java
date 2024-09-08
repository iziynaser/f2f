package com.f2f.dao.content;

import com.f2f.entity.content.Article;
import com.f2f.entity.content.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTagDao  extends CrudRepository<Content,Long> {
}
