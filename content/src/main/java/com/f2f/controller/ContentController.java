package com.f2f.controller;

import com.f2f.dto.ContentSearchForm;
import com.f2f.dto.ContentDTO;
import com.f2f.dto.ContentStatusDTO;
import com.f2f.entity.Content;
import com.f2f.eums.ContentStatusType;
import com.f2f.service.ContentService;
import com.f2f.service.ContentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ContentController")
@RequestMapping("/f2f/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO dto) {
        ContentDTO created = contentService.createContent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDTO> updateContent(@PathVariable Long id, @RequestBody ContentDTO dto) {
        ContentDTO updated = contentService.updateContent(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDTO> getContentById(@PathVariable Long id) {
        return contentService.getContentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<ContentDTO> getContentBySlug(@PathVariable String slug) {
        return contentService.getContentBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ContentDTO>> getContentsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(contentService.getContentsByCategoryId(categoryId));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<ContentDTO>> getContentsByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(contentService.getContentsByLanguage(language));
    }

    @PostMapping("/{contentId}/category/{categoryId}")
    public ResponseEntity<Void> assignToCategory(@PathVariable Long contentId, @PathVariable Long categoryId) {
        contentService.assignContentToCategory(contentId, categoryId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{contentId}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable Long contentId,
            @RequestParam ContentStatusType status,
            @RequestParam Long userId
    ) {
        contentService.updateContentStatus(contentId, status, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{contentId}/statuses")
    public ResponseEntity<List<ContentStatusDTO>> getStatuses(@PathVariable Long contentId) {
        return ResponseEntity.ok(contentService.getContentStatuses(contentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}
