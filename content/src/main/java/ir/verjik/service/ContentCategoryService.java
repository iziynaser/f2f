package ir.verjik.service;

import ir.verjik.dto.ContentCategoryDTO;

import java.util.List;

public interface ContentCategoryService {
    ContentCategoryDTO assignCategoryToContent(Long contentId, Long categoryId);
    void removeCategoryFromContent(Long contentId, Long categoryId);
    List<Long> getCategoryIdsForContent(Long contentId);
    List<Long> getContentIdsForCategory(Long categoryId);
    boolean isContentInCategory(Long contentId, Long categoryId);
}
