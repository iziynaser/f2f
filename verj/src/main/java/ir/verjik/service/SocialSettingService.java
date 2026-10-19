package ir.verjik.service;

import ir.verjik.entity.other.SocialSettingDTO;
import ir.verjik.entity.other.SocialSetting;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
//@PreAuthorize("isAuthenticated()")
public class SocialSettingService {

//    @Autowired
//    SocialSettingDao socialSettingDao ;

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
