package com.f2f.dao;

import com.f2f.entity.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PageDao")
@Repository
public interface PageDao extends CrudRepository<Page,Long> {
}
