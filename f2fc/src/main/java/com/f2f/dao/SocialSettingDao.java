package com.f2f.dao;

import com.f2f.entity.SocialSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("SocialSetting")
@Repository
public interface SocialSettingDao extends JpaRepository<SocialSetting,Long> {

}
