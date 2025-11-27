package com.f2f.controller;

import com.f2f.dto.CategoryDTO;
import com.f2f.dto.CategoryTreeDTO;
import com.f2f.entity.Category;
import com.f2f.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/store/Category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listTop10WithSub")
    public ResponseEntity<List<CategoryTreeDTO>> getTop10WithSubCategories() {
        List<CategoryTreeDTO> dtos = categoryService.findTop10WithSubCategories();
        return ResponseEntity.ok(dtos);
    }


    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.save(categoryDTO);
        return ResponseEntity.ok(category);
    }


    @ResponseBody
    @PostMapping(value = "/save")
    public Category save(@RequestBody CategoryDTO categoryDTO){
        Category c = categoryService.save(categoryDTO);
        return c;
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @ResponseBody
    @GetMapping(value="/listById")
    public List<Category> findAllCategoriesById(Long id, Long cId){
        //todo: handle client values for null
        Long parentCategoryId = (id==null)? new Long("1") : id;
        Long categoryTypeId = (cId==null) ? new Long("8") : cId ;

        List<Category> categories = categoryService.findAllByParentCategoryAndCategoryType(parentCategoryId,categoryTypeId);
        return categories;
    }
}
