package ir.verjik.service;

import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.dto.ContentDTO;
import ir.verjik.dto.ContentStatusDTO;
import ir.verjik.entity.Content;
import ir.verjik.entity.ContentCategory;
import ir.verjik.entity.ContentStatus;
import ir.verjik.entity.Tag;
import ir.verjik.eums.ContentStatusType;
import ir.verjik.eums.ContentTargetType;
import ir.verjik.mapper.ContentMapper;
import ir.verjik.mapper.ContentStatusMapper;
import ir.verjik.repository.ContentCategoryRepository;
import ir.verjik.repository.ContentRepository;
import ir.verjik.repository.ContentStatusRepository;
import ir.verjik.repository.TagRepository;
import ir.verjik.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    private final ContentMapper contentMapper;
    private final ContentCategoryRepository contentCategoryRepository;
    private final ContentStatusRepository contentStatusRepository;
    private final ContentStatusMapper contentStatusMapper;

    @Override
    public ContentDTO createContent(ContentDTO dto) {
        Content entity = contentMapper.toEntity(dto);

        // ضد XSS با Jsoup
        entity.setBody(Jsoup.clean(dto.getBody(), Safelist.basicWithImages()));

        // تگ‌ها
        if (dto.getTags() != null && !dto.getTags().isEmpty()) {
            List<Tag> tags = tagRepository.findByNameIn(dto.getTags());
            entity.setTags(tags);
        }

        entity.setDate(LocalDateTime.now());

        // تولید slug یکتا
        String baseSlug = (dto.getSlug() != null && !dto.getSlug().trim().isEmpty())
                ? SlugUtil.toSlug(dto.getSlug())
                : SlugUtil.toSlug(dto.getTitle());
        entity.setSlug(generateUniqueSlug(baseSlug));

        Content saved = contentRepository.save(entity);
        return contentMapper.toDto(saved);
    }

    @Override
    public ContentDTO updateContent(Long id, ContentDTO dto) {
        Content entity = contentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Content not found with id: " + id));

        // ضد XSS
        entity.setBody(Jsoup.clean(dto.getBody(), Safelist.basicWithImages()));

        // به‌روزرسانی فیلدها
        entity.setTitle(dto.getTitle());
        entity.setLanguage(dto.getLanguage());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getPublishDate());

        // تگ‌ها
        if (dto.getTags() != null) {
            List<Tag> tags = tagRepository.findByNameIn(dto.getTags());
            entity.setTags(tags);
        }

        // تولید slug جدید اگر تغییر کرده باشد
        String newSlug = (dto.getSlug() != null && !dto.getSlug().trim().isEmpty())
                ? SlugUtil.toSlug(dto.getSlug())
                : SlugUtil.toSlug(dto.getTitle());
        if (!newSlug.equals(entity.getSlug())) {
            entity.setSlug(generateUniqueSlug(newSlug));
        }

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

    @Override
    public Optional<ContentDTO> getContentByTarget(Long targetId, String targetType, String language) {
        ContentTargetType typeEnum;
        try {
            typeEnum = ContentTargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            typeEnum = ContentTargetType.OTHER;
        }

        return contentRepository
                .findByTargetIdAndTargetTypeAndLanguage(targetId, typeEnum, language)
                .map(contentMapper::toDto);
    }

    // متد کمکی برای تولید slug یکتا
    private String generateUniqueSlug(String baseSlug) {
        String slug = baseSlug;
        int count = 0;
        while (contentRepository.existsBySlug(slug)) {
            count++;
            slug = baseSlug + "-" + count;
        }
        return slug;
    }
}
