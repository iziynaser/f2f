package com.f2f.dao.content;

import com.f2f.entity.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("ContentDao")
public interface ContentDao extends JpaRepository<Content,Long>,JpaSpecificationExecutor<Content> {

    //@Query("select count(content.id) from Content content where content.status = :status and content.language = :language")
    //long countByStatus(@Param("status") String status , @Param("language") String language);

    //count by category

    Content findFirstByIdAndLanguage(Long id,String language);

    Optional<Content> getContentByCodeAndLanguage(String code , String language);

}
