package com.f2f.controller;

import com.f2f.entity.other.SocialSettingDTO;
import com.f2f.service.SocialSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("socialSettingController")
@RequestMapping("/socialSetting")
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
