package com.f2f.back.controller;

import com.f2f.back.dao.SocialSettingDTO;
import com.f2f.back.service.SocialSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("socialSettingController")
@RequestMapping("/f2f/socialSetting")
public class socialSettingController {

    @Autowired
    SocialSettingService socialSettingService;

    @ResponseBody
    @PostMapping(value = "/saveOrUpdate")
    public SocialSettingDTO saveOrUpdateSocialSetting(@RequestBody SocialSettingDTO socialSettingDTO){
        SocialSettingDTO ss = socialSettingService.saveOrUpdate(socialSettingDTO);
        return ss;
    }

}
