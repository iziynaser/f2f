package com.f2f.dao;

import com.f2f.dbc.entity.CategoryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("CategoryTypeDao")
@Repository
public interface CategoryTypeDao extends CrudRepository<CategoryType,Long> {
}
