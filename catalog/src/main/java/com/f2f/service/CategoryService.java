package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.entity.CategoryType;
import com.f2f.dto.CategoryDTO;
import com.f2f.dto.CategoryTreeDTO;
import com.f2f.entity.Category;
import com.f2f.mapper.CategoryMapper;
import com.f2f.repository.CategoryRepository;
import com.f2f.repository.CategoryTypeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTypeRepository categoryTypeRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryTypeRepository categoryTypeRepository,
                            CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryTypeRepository = categoryTypeRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryTreeDTO> findTop10WithSubCategories() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
        List<Category> categories = categoryRepository.findTopCategoriesWithoutParent(7);
        return categoryMapper.toCategoryTreeDTOList(categories);
    }

    public Category save(CategoryDTO categoryDTO) {
        Category parentCategory = categoryRepository.findById(
                Long.parseLong(categoryDTO.getParentCategory())
        ).orElseThrow(() -> new EntityNotFoundException("Parent category not found"));

        CategoryType categoryType = categoryTypeRepository.findById(
                Long.parseLong(categoryDTO.getCategoryType())
        ).orElseThrow(() -> new EntityNotFoundException("Category type not found"));

        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setCategoryCode(categoryDTO.getCategoryCode());
        category.setParentCategory(parentCategory);
        category.setCategoryType(categoryType);

        return categoryRepository.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> findAllByParentCategoryAndCategoryType(Long parentCategoryId, Long categoryTypeId) {
        Category parentCategory = categoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Parent category not found"));

        CategoryType categoryType = categoryTypeRepository.findById(categoryTypeId)
                .orElseThrow(() -> new EntityNotFoundException("Category type not found"));

        return categoryRepository.findByParentCategoryAndCategoryType(parentCategory, categoryType);
    }
}
