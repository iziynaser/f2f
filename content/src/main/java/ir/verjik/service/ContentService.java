package ir.verjik.service;

import ir.verjik.dto.ContentDTO;
import ir.verjik.dto.ContentStatusDTO;
import ir.verjik.eums.ContentStatusType;

import java.util.List;
import java.util.Optional;

public interface ContentService {

    ContentDTO createContent(ContentDTO dto);

    ContentDTO updateContent(Long id, ContentDTO dto);

    Optional<ContentDTO> getContentById(Long id);

    Optional<ContentDTO> getContentBySlug(String slug);

    List<ContentDTO> getContentsByCategoryId(Long categoryId);

    List<ContentDTO> getContentsByLanguage(String language);

    void assignContentToCategory(Long contentId, Long categoryId);

    void updateContentStatus(Long contentId, ContentStatusType status, Long userId);

    List<ContentStatusDTO> getContentStatuses(Long contentId);

    // در صورت نیاز متدهای حذف و سایر جستجوها هم اضافه می‌شود
    void deleteContent(Long id);

    Optional<ContentDTO> getContentByTarget(Long targetId, String targetType, String language);


}
