package ir.verjik.service;

import ir.verjik.dto.PageDTO;

import java.util.List;
import java.util.Optional;

public interface PageService {
    PageDTO createPage(PageDTO pageDTO);
    PageDTO updatePage(Long id, PageDTO pageDTO);
    public Optional<PageDTO> getPageById(Long id);
    List<PageDTO> getAllPages();
    void deletePage(Long id);
    Optional<PageDTO> getPageByTarget(Long targetId, String targetType, String language);
    Optional<PageDTO> getPageBySlug(String slug);

}
