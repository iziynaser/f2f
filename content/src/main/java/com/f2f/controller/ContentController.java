package com.f2f.controller;

import com.f2f.dao.ContentSearchForm;
import com.f2f.dto.ContentDTO;
import com.f2f.entity.Content;
import com.f2f.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController("ContentController")
@RequestMapping("/f2f/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @PostMapping(value = "/save")
    public Content createContent(@RequestBody ContentDTO contentDTO){
        Content c = contentService.save(contentDTO);
        return c;
    }

    @ResponseBody
    @GetMapping("/load")
    public Content getContentByCode(String code, String language){
        Content content = contentService.getContentByCodeAndLangauge(code,language);
        return content;
    }

    @ResponseBody
    @PostMapping("/search")
    public Page<Content>  search(ContentSearchForm contentSearchForm, Pageable pageable){
        Page<Content> contentList = contentService.testPagableWithSpecification(contentSearchForm,pageable);
        return contentList;
    }

}
