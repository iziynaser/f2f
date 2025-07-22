package com.f2f.service;

import com.f2f.dto.ContentSearchForm;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.ContentDTO;
import com.f2f.dto.ContentStatusDTO;
import com.f2f.entity.Content;
import com.f2f.entity.ContentCategory;
import com.f2f.entity.ContentStatus;
import com.f2f.entity.Tag;
import com.f2f.eums.ContentStatusType;
import com.f2f.mapper.ContentMapper;
import com.f2f.mapper.ContentStatusMapper;
import com.f2f.repository.ContentCategoryRepository;
import com.f2f.repository.ContentRepository;
import com.f2f.repository.ContentStatusRepository;
import com.f2f.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContentServiceImpl  implements ContentService {

    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    private final ContentMapper contentMapper;
    private final ContentCategoryRepository contentCategoryRepository;
    private final ContentStatusRepository contentStatusRepository;
    private final ContentStatusMapper contentStatusMapper;

    @Override
    public ContentDTO createContent(ContentDTO dto) {
        Content entity = contentMapper.toEntity(dto);
        // مدیریت تگ‌ها و سایر موارد اگر نیاز هست اینجا انجام شود
        Content saved = contentRepository.save(entity);
        return contentMapper.toDto(saved);
    }

    @Override
    public ContentDTO updateContent(Long id, ContentDTO dto) {
        Content entity = contentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Content not found with id: " + id));

        // آپدیت فیلدهای مورد نظر
        entity.setTitle(dto.getTitle());
        entity.setSlug(dto.getSlug());
        entity.setLanguage(dto.getLanguage());
        entity.setDescription(dto.getSummary());
        entity.setDate(dto.getPublishDate());
        // مدیریت تگ‌ها و ... در صورت نیاز

        Content updated = contentRepository.save(entity);
        return contentMapper.toDto(updated);
    }

    @Override
    public Optional<ContentDTO> getContentById(Long id) {
        return contentRepository.findById(id).map(contentMapper::toDto);
    }

    @Override
    public Optional<ContentDTO> getContentBySlug(String slug) {
        return contentRepository.findBySlug(slug).map(contentMapper::toDto);
    }

    @Override
    public List<ContentDTO> getContentsByCategoryId(Long categoryId) {
        // دسته بندی محتوا در جدول ContentCategory است
        List<ContentCategory> contentCategories = contentCategoryRepository.findByCategoryId(categoryId);
        List<Long> contentIds = contentCategories.stream()
                .map(cc -> cc.getContent().getId())
                .collect(Collectors.toList());

        List<Content> contents = contentRepository.findAllById(contentIds);
        return contentMapper.toDtoList(contents);
    }

    @Override
    public List<ContentDTO> getContentsByLanguage(String language) {
        List<Content> contents = contentRepository.findByLanguage(language);
        return contentMapper.toDtoList(contents);
    }

    @Override
    public void assignContentToCategory(Long contentId, Long categoryId) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new EntityNotFoundException("Content not found"));

        // بررسی اگر قبلا این رابطه وجود داشته باشد
        List<ContentCategory> existing = contentCategoryRepository.findByContent(content);
        boolean exists = existing.stream()
                .anyMatch(cc -> cc.getCategoryId().equals(categoryId));

        if (!exists) {
            ContentCategory cc = new ContentCategory();
            cc.setContent(content);
            cc.setCategoryId(categoryId);
            contentCategoryRepository.save(cc);
        }
    }

    @Override
    public void updateContentStatus(Long contentId, ContentStatusType status, Long userId) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new EntityNotFoundException("Content not found"));

        ContentStatus contentStatus = new ContentStatus();
        contentStatus.setContent(content);
        contentStatus.setStatus(status);
        contentStatus.setUserAccountId(userId);
        contentStatusRepository.save(contentStatus);
    }

    @Override
    public List<ContentStatusDTO> getContentStatuses(Long contentId) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new EntityNotFoundException("Content not found"));
        List<ContentStatus> statuses = contentStatusRepository.findByContent(content);
        return contentStatusMapper.toDtoList(statuses);
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }


    public Content create(ContentDTO dto) {
        Content content = contentMapper.toEntity(dto);

        if (dto.getTags() != null) {
            List<Tag> tags = tagRepository.findByNameIn(dto.getTags());
            content.setTags(tags);
        }

        return contentRepository.save(content);
    }

    public Content getContentByCodeAndLangauge(String code, String language) {
        Optional<Content> optionalContent = contentRepository.getContentByCodeAndLanguage(code,language);
        Content c= optionalContent.orElseThrow(EntityNotFoundException::new);
        return c;
    }

}
