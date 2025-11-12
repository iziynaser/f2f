package com.f2f.controller;

import com.f2f.dto.ContentCategoryDTO;
import com.f2f.service.ContentCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ContentCategoryController")
@RequestMapping("/contentCategory")
@RequiredArgsConstructor
public class ContentCategoryController {

    private final ContentCategoryService service;

    @PostMapping("/assign")
    public ResponseEntity<ContentCategoryDTO> assignCategory(
            @RequestParam Long contentId,
            @RequestParam Long categoryId) {
        return ResponseEntity.ok(service.assignCategoryToContent(contentId, categoryId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeCategory(
            @RequestParam Long contentId,
            @RequestParam Long categoryId) {
        service.removeCategoryFromContent(contentId, categoryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories/{contentId}")
    public List<Long> getCategories(@PathVariable Long contentId) {
        return service.getCategoryIdsForContent(contentId);
    }

    @GetMapping("/contents/{categoryId}")
    public List<Long> getContents(@PathVariable Long categoryId) {
        return service.getContentIdsForCategory(categoryId);
    }
}
