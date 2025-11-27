package com.f2f.controller;

import com.f2f.dto.CategoryTreeDTO;
import com.f2f.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/store/category")
public class CategoryController2 {
    private final CategoryService categoryService;

    public CategoryController2(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listTop10")
    public ResponseEntity<List<CategoryTreeDTO>> getTop10WithSubCategories() {
        List<CategoryTreeDTO> dtos = categoryService.findTop10WithSubCategories();
        return ResponseEntity.ok(dtos);
    }

}
