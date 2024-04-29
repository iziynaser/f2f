package com.f2f.dao;

import com.f2f.entity.common.CategoryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CategoryTypeDao")
public interface CategoryTypeDao extends CrudRepository<CategoryType,Long> {
}
