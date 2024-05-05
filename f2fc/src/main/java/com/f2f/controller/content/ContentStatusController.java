package com.f2f.controller.content;

import com.f2f.entity.content.ContentStatus;
import com.f2f.service.content.ContentStatusService;
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
