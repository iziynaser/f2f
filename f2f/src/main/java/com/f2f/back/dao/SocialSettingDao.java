package com.f2f.back.dao;

import com.f2f.back.entity.SocialSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SocialSetting")
public interface SocialSettingDao extends JpaRepository<SocialSetting,Long> {

}
