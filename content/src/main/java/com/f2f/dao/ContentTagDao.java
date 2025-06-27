package com.f2f.dao;

import com.f2f.entity.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTagDao  extends CrudRepository<Content,Long> {
}
