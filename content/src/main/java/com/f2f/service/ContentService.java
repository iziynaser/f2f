package com.f2f.service;

import com.f2f.dto.ContentSearchForm;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.ContentDTO;
import com.f2f.entity.Content;
import com.f2f.entity.Tag;
import com.f2f.mapper.ContentMapper;
import com.f2f.repository.ContentRepository;
import com.f2f.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    private final ContentMapper contentMapper;

    public Content create(ContentDTO dto) {
        Content content = contentMapper.toEntity(dto);

        if (dto.getTags() != null) {
            List<Tag> tags = tagRepository.findByNameIn(dto.getTags());
            content.setTags(tags);
        }

        return contentRepository.save(content);
    }


    public Content save(ContentDTO contentDTO) {
        Content c = new Content();
        //c.setBody(contentDTO.getBody());
        //c.setCode(contentDTO.getCode());
        //c.setDate(contentDTO.getDate());
        //c.setLanguage(contentDTO.getLanguage());
        //c.setStatus(contentDTO.getStatus());
        contentRepository.save(c);
        return c;
    }

    public Content getContentByCodeAndLangauge(String code, String language) {
        Optional<Content> optionalContent = contentRepository.getContentByCodeAndLanguage(code,language);
        Content c= optionalContent.orElseThrow(EntityNotFoundException::new);
        return c;
    }

    public  Page<Content> testPagableWithSpecification(ContentSearchForm contentSearchForm, @PageableDefault(7) Pageable pageable){

//        ContentSecification cSpecification = new ContentSecification();
//        //cSpecification.add(new SearchCriteria("title","a",SearchOperation.MATCH));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getName()))
//            cSpecification.add(new SearchCriteria("name",contentSearchForm.getName(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getTitle()))
//            cSpecification.add(new SearchCriteria("title",contentSearchForm.getTitle(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getPurpose()))
//            cSpecification.add(new SearchCriteria("purpose",contentSearchForm.getPurpose(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getFromDate()))
//            cSpecification.add(new SearchCriteria("fromDate",contentSearchForm.getFromDate(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getToDate()))
//            cSpecification.add(new SearchCriteria("toDate",contentSearchForm.getToDate(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getIsPublic()))
//            cSpecification.add(new SearchCriteria("isPublic",contentSearchForm.getIsPublic(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getStatus()))
//            cSpecification.add(new SearchCriteria("status",contentSearchForm.getStatus(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getDescription()))
//            cSpecification.add(new SearchCriteria("description",contentSearchForm.getDescription(),SearchOperation.EQUAL));
//
//        //if(!NumberUtils.isDigits(contentSearchForm.getSeq()))
//        //    cSpecification.add(new SearchCriteria("seq",contentSearchForm.getSeq(),SearchOperation.EQUAL));
//
//        if(!StringUtils.isEmpty(contentSearchForm.getContentType()))
//            cSpecification.add(new SearchCriteria("contentType",contentSearchForm.getContentType(),SearchOperation.EQUAL));

        //Pageable pageable = PageRequest.of(page,size,Sort.by("title").ascending());
        //Page<Content> contentList = contentDao.findAll();//cSpecification,pageable);
        //contentList.forEach(System.out::println);
        //return contentList;
        return null;
    }

}
