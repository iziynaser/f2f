package ir.verjik.service;

import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.dto.PageDTO;
import ir.verjik.entity.Page;
import ir.verjik.mapper.PageMapper;
import ir.verjik.repository.PageRepository;
import ir.verjik.util.SlugUtil;
import ir.verjik.util.XssSanitizerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final PageMapper pageMapper;

    @Override
    public PageDTO createPage(PageDTO pageDTO) {
        sanitizePageDTO(pageDTO);

        // تولید slug یکتا
        String baseSlug = SlugUtil.toSlug(pageDTO.getTitle());
        pageDTO.setSlug(generateUniqueSlug(baseSlug));

        Page page = pageMapper.toEntity(pageDTO);
        return pageMapper.toDto(pageRepository.save(page));
    }

    @Override
    public PageDTO updatePage(Long id, PageDTO pageDTO) {
        Page existingPage = pageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));

        sanitizePageDTO(pageDTO);

        existingPage.setTitle(pageDTO.getTitle());

        // اگر عنوان تغییر کرده، slug را هم به‌روزرسانی کن
        String baseSlug = SlugUtil.toSlug(pageDTO.getTitle());
        if (!baseSlug.equals(existingPage.getSlug())) {
            existingPage.setSlug(generateUniqueSlug(baseSlug));
        }

        // به‌روزرسانی فیلدهای دیگر
        existingPage.setContentId(pageDTO.getContentId());
        existingPage.setContentId(pageDTO.getContentId());
        existingPage.setLanguage(pageDTO.getLanguage());
        existingPage.setPageNumber(pageDTO.getPageNumber());
        existingPage.setSlug(existingPage.getSlug());
        existingPage.setCommentTargetId(pageDTO.getCommentTargetId());
        existingPage.setSlug(existingPage.getSlug());

        return pageMapper.toDto(pageRepository.save(existingPage));
    }

    @Override
    public Optional<PageDTO> getPageById(Long id) {
        return pageRepository.findById(id).map(pageMapper::toDto);
    }

    @Override
    public List<PageDTO> getAllPages() {
        return pageRepository.findAll().stream().map(pageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }

    private void sanitizePageDTO(PageDTO pageDTO) {
        if (pageDTO.getTitle() != null) {
            pageDTO.setTitle(XssSanitizerUtil.sanitize(pageDTO.getTitle()));
        }
        if (pageDTO.getContent() != null) {
            pageDTO.setContent(XssSanitizerUtil.sanitizeHtml(pageDTO.getContent()));
        }
    }

    @Override
    public Optional<PageDTO> getPageByTarget(Long targetId, String targetType, String language) {
        return pageRepository.findByContentIdAndLanguage(targetId, language)
                .map(pageMapper::toDto);
    }

    @Override
    public Optional<PageDTO> getPageBySlug(String slug) {
        return pageRepository.findBySlug(slug).map(pageMapper::toDto);
    }

    // متد کمکی برای تولید slug یکتا
    private String generateUniqueSlug(String baseSlug) {
        String slug = baseSlug;
        int count = 0;
        while (pageRepository.existsBySlug(slug)) {
            count++;
            slug = baseSlug + "-" + count;
        }
        return slug;
    }
}
