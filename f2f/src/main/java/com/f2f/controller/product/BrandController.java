package com.f2f.controller.product;

import com.f2f.entity.common.Category;
import com.f2f.entity.product.Brand;
import com.f2f.entity.product.BrandDTO;
import com.f2f.service.CategoryService;
import com.f2f.service.product.BrandService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController("BrandController")
@RequestMapping("/f2f/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public List<Brand> getDogs(){
        List<Brand> rt = brandService.findAll();
        return rt;
    }

    @GetMapping("/brand/{id}")
    public Brand  findById(@PathVariable(value = "id") Long id)throws NotFoundException{
        Optional<Brand> b= brandService.findById(id);
        if(!b.isPresent())
            throw new NotFoundException("id:"+id);
        return b.get();
    }

    @GetMapping("/byCategoryId")
    public List<Brand> findAllBrandsByCategoryId(Long categoryId){
        Category category = categoryService.findCategoryById(categoryId);
        List<Brand> result = brandService.getAllBrandsByCategoryId(category);
        return result;
    }

    @ResponseBody
    @PostMapping(value="/save")
    public Brand createBrand(@RequestBody BrandDTO brandDTO)
    {
        Category category = categoryService.findCategoryById(brandDTO.getCategoryId());
        Brand brand=new Brand();
        brand.setName(brandDTO.getName());
        brand.setValue(brandDTO.getValue());
        brand.setCategoryId(category);

        Brand b = brandService.save(brand);
        return b;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteById(@PathVariable Long id)throws NotFoundException{
        Optional<Brand> b= brandService.findById(id);
        if(!b.isPresent())
            throw new NotFoundException("id:"+id);

        brandService.delete(b.get());
        HashMap response = new HashMap();
        response.put("deleted",true);
        return response;
    }

}
