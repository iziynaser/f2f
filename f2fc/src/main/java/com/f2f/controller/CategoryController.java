package com.f2f.controller;

import com.f2f.entity.common.Category;
import com.f2f.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/f2f/Category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @PostMapping(value = "/save")
    public Category save(@RequestBody CategoryDTO categoryDTO){
        Category c = categoryService.save(categoryDTO);
        return c;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Category> findAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        return categories;
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

//    @ResponseBody
//    @GetMapping(value="/listById")
//    public List<Category> findAllCategoriesById(Long id){
//        List<Category> categories = categoryService.findAllByParentCategory(id);
//        return categories;
//    }




}
