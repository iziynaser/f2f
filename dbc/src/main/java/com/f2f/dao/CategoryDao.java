package com.f2f.dao;

import com.f2f.dbc.entity.CategoryType;
import com.f2f.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("CategoryDao")
@Repository
public interface CategoryDao  extends CrudRepository<Category,Long> {

//    Iterable<Category> findAllByParentCategory(Category parentCategory);
    Iterable<Category> findAllByParentCategoryAndCategoryType(Category parentCategory, CategoryType categoryType);
}
