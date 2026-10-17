package ir.verjik.dao;

import ir.verjik.entity.other.SocialSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("SocialSetting")
@Repository
public interface SocialSettingDao extends JpaRepository<SocialSetting,Long> {

}
