package com.f2f.service;

import com.f2f.controller.CategoryDTO;
import com.f2f.dao.CategoryDao;
import com.f2f.dao.CategoryTypeDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.common.Category;
import com.f2f.entity.common.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
     CategoryDao categoryDao;

    @Autowired
    CategoryTypeDao categoryTypeDao;

//    @Autowired
//    CategoryService(CategoryDao categoryDao){
//        this.categoryDao = categoryDao;
//    }
    public Category save(CategoryDTO categoryDTO){

        Optional<Category> optionalCategory = categoryDao.findById(Long.valueOf(categoryDTO.getParentCategory()));
        Category parentCategory = optionalCategory.orElseThrow(EntityNotFoundException::new);

        Optional<CategoryType> optionalCategoryType = categoryTypeDao.findById(Long.valueOf(categoryDTO.getCategoryType()));
        CategoryType categoryType = optionalCategoryType.orElseThrow(EntityNotFoundException::new);

        Category category = new Category();
        category.setParentCategory(parentCategory);
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setCategoryCode(categoryDTO.getCategoryCode());
        category.setCategoryType(categoryType);

        Category c = categoryDao.save(category);
        return c;
    }

    public Category findCategoryById(Long id){
        Optional<Category> optionalCategory = categoryDao.findById(id);
        Category category = optionalCategory.orElseThrow(EntityNotFoundException::new);
        return category;
    }

    public List<Category> findAllCategories() {
        List<Category> categoryList = (List<Category>) categoryDao.findAll();
        return categoryList;
    }

//    public List<Category> findAllByParentCategory(Long id) {
//        List<Category> result=new ArrayList<>();
//        Optional<Category>  optionalCategory = categoryDao.findById(id);
//        Category category = optionalCategory.orElseThrow(EntityNotFoundException::new);
//        Iterable<Category> categories= categoryDao.findAllByParentCategory(category);
//        categories.forEach(c -> result.add(c));
//        return result;
//    }

    public List<Category> findAllByParentCategoryAndCategoryType(Long parentCategoryId,Long categoryTypeId) {
        List<Category> result=new ArrayList<>();
        Optional<Category>  optionalCategory = categoryDao.findById(parentCategoryId);
        Category parentCategory = optionalCategory.orElseThrow(EntityNotFoundException::new);

        Optional<CategoryType> optionalCategoryType=categoryTypeDao.findById(categoryTypeId);
        CategoryType categoryType = optionalCategoryType.orElseThrow(EntityNotFoundException::new);

        Iterable<Category> categories= categoryDao.findAllByParentCategoryAndCategoryType(parentCategory,categoryType);
        categories.forEach(c -> result.add(c));
        return result;
    }

}
