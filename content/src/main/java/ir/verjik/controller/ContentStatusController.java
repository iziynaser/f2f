package ir.verjik.controller;

import ir.verjik.entity.ContentStatus;
import ir.verjik.service.ContentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ContentStatusController")
@RequestMapping("/contentStatus")
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
