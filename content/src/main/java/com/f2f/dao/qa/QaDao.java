package com.f2f.dao.qa;

import com.f2f.dto.QaDTO;
import com.f2f.entity.qa.Qa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QaDao extends JpaRepository<Qa,Long> {
    @Query(nativeQuery= true,value = "select question,status,brief_answer as briefAnswer,answered_by as answeredBy,answered_date as answeredDate,additional_answer as additionalAnswer" +
            " from qa " +
            " where product_id = :id")
    List<QaDTO> getListOfQasForProductId(@Param("id") Long productId);
}
