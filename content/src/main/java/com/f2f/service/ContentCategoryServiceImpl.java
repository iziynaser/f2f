package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.ContentCategoryDTO;
import com.f2f.entity.Content;
import com.f2f.entity.ContentCategory;
import com.f2f.repository.ContentCategoryRepository;
import com.f2f.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentCategoryServiceImpl implements ContentCategoryService {

    private final ContentCategoryRepository repository;
    private final ContentRepository contentRepository;

    @Override
    public ContentCategoryDTO assignCategoryToContent(Long contentId, Long categoryId) {
        if (!contentRepository.existsById(contentId))
            throw new EntityNotFoundException("Content not found");

        if (repository.existsByContentIdAndCategoryId(contentId, categoryId))
            throw new IllegalStateException("Content already in category");

        ContentCategory cc = new ContentCategory();
        cc.setContent(new Content(contentId));
        cc.setCategoryId(categoryId);

        repository.save(cc);

        return ContentCategoryDTO.builder()
                .id(cc.getId())
                .contentId(contentId)
                .categoryId(categoryId)
                .build();
    }

    @Override
    public void removeCategoryFromContent(Long contentId, Long categoryId) {
        repository.deleteByContentIdAndCategoryId(contentId, categoryId);
    }

    @Override
    public List<Long> getCategoryIdsForContent(Long contentId) {
        return repository.findByContentId(contentId)
                .stream().map(ContentCategory::getCategoryId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getContentIdsForCategory(Long categoryId) {
        return repository.findByCategoryId(categoryId)
                .stream().map(cc -> cc.getContent().getId())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isContentInCategory(Long contentId, Long categoryId) {
        return repository.existsByContentIdAndCategoryId(contentId, categoryId);
    }
}
