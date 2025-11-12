package com.f2f.controller;

import com.f2f.dto.PageDTO;
import com.f2f.exception.ResourceNotFoundException;
import com.f2f.response.ApiSuccessResponse;
import com.f2f.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @PostMapping
    public ResponseEntity<PageDTO> createPage(@RequestBody PageDTO pageDTO) {
        PageDTO createdPage = pageService.createPage(pageDTO);
        return new ResponseEntity<>(createdPage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageDTO> updatePage(@PathVariable Long id, @RequestBody PageDTO pageDTO) {
        PageDTO updatedPage = pageService.updatePage(id, pageDTO);
        return ResponseEntity.ok(updatedPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageDTO> getPage(@PathVariable Long id) {
        return pageService.getPageById(id)
                .map(ResponseEntity::ok)                // اگر صفحه وجود داشت، 200 OK با صفحه برمی‌گرداند
                .orElse(ResponseEntity.notFound().build()); // اگر صفحه نبود، 404 برمی‌گرداند
    }


    @GetMapping
    public ResponseEntity<List<PageDTO>> getAllPages() {
        return ResponseEntity.ok(pageService.getAllPages());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        pageService.deletePage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-target")
    public ResponseEntity<ApiSuccessResponse<PageDTO>> getPageByTarget(
            @RequestParam("targetId") Long targetId,
            @RequestParam("targetType") String targetType,
            @RequestParam(value = "language", defaultValue = "fa") String language
    ) {
        PageDTO page = pageService.getPageByTarget(targetId, targetType, language)
                .orElseThrow(() -> new ResourceNotFoundException("page.not.found", new Object[]{targetId, targetType}));

        ApiSuccessResponse<PageDTO> response = ApiSuccessResponse.<PageDTO>builder()
                .message("صفحه با موفقیت یافت شد")
                .detail("داده برای targetId و targetType ارسال شد")
                .body(page)
                .build();

        return ResponseEntity.ok(response);
    }

}
