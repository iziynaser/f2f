package com.f2f.service.content;

import com.f2f.dao.content.ContentDao;
import com.f2f.dao.content.ContentSearchForm;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.content.Content;
import com.f2f.entity.content.ContentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public Content save(ContentDTO contentDTO) {
        Content c = new Content();
        c.setBody(contentDTO.getBody());
        c.setCode(contentDTO.getCode());
        c.setDate(contentDTO.getDate());
        c.setLanguage(contentDTO.getLanguage());
        //c.setStatus(contentDTO.getStatus());
        contentDao.save(c);
        return c;
    }

    public Content getContentByCodeAndLangauge(String code, String language) {
        Optional<Content> optionalContent = contentDao.getContentByCodeAndLanguage(code,language);
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
