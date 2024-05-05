package com.f2f.back.service;

import com.f2f.back.dao.SocialSettingDTO;
import com.f2f.back.dao.SocialSettingDao;
import com.f2f.back.entity.SocialSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@PreAuthorize("isAuthenticated()")
public class SocialSettingService {

    @Autowired
    SocialSettingDao socialSettingDao ;

    public SocialSettingDTO saveOrUpdate(SocialSettingDTO socialSettingDTO) {
        SocialSetting socialSetting = new SocialSetting();
        socialSetting.setAparatAddress(socialSettingDTO.getAparatAddress());
        socialSetting.setAparatAddressEnabled(socialSettingDTO.getAparatAddressEnabled());
        socialSetting.setInstaAddress(socialSettingDTO.getInstaAddress());
        socialSetting.setInstaAddressEnabled(socialSettingDTO.getInstaAddressEnabled());
        socialSetting.setTwitterAddress(socialSettingDTO.getTwitterAddress());
        socialSetting.setTwitterAddressEnabled(socialSettingDTO.getTwitterAddressEnabled());
        socialSetting.setLinkedInAddress(socialSettingDTO.getLinkedInAddress());
        socialSetting.setLinkedInAddressEnabled(socialSettingDTO.getLinkedInAddressEnabled());

        return socialSettingDTO;
    }
}
