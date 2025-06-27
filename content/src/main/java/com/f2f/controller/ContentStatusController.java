package com.f2f.controller;

import com.f2f.entity.ContentStatus;
import com.f2f.service.ContentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ContentStatusController")
@RequestMapping("/f2f/contentStatus")
public class ContentStatusController {

    @Autowired
    ContentStatusService contentStatusService;

    @ResponseBody
    @PostMapping(value = "/save")
    public ContentStatus createContentStatus(@RequestBody ContentStatus contentStatus){
        //Content c = contentService.save(contentDTO);
        //return c;
        return null;
    }

}
