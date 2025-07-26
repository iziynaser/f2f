package com.f2f.controller;

import com.f2f.dto.ContentDTO;
import com.f2f.dto.PageDTO;
import com.f2f.service.ContentService;
import com.f2f.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/f2f/slug")
@RequiredArgsConstructor
public class SlugController {

    private final ContentService contentService;
    private final PageService pageService;

    @GetMapping("/content/{slug}")
    public ResponseEntity<ContentDTO> getContentBySlug(@PathVariable String slug) {
        return contentService.getContentBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/page/{slug}")
    public ResponseEntity<PageDTO> getPageBySlug(@PathVariable String slug) {
        return pageService.getPageBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
