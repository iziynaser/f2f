package com.f2f.dao;

import com.f2f.entity.common.Category;
import com.f2f.entity.common.CategoryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CategoryDao")
public interface CategoryDao  extends CrudRepository<Category,Long> {

//    Iterable<Category> findAllByParentCategory(Category parentCategory);
    Iterable<Category> findAllByParentCategoryAndCategoryType(Category parentCategory, CategoryType categoryType);
}
