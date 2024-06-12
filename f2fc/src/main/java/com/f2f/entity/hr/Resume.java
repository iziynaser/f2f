package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESUME")
public class Resume extends BaseEntity implements Serializable {

    @Column(name = "CONTENT_FILE")
    private String contentFile ;

    @Column(name = "RESUME_DATE")
    private String resumeDate ;

    private Person person;

    public Resume() {
    }

    public Resume(String contentFile, String resumeDate) {
        this.contentFile = contentFile;
        this.resumeDate = resumeDate;
    }

    public String getContentFile() {
        return contentFile;
    }

    public void setContentFile(String contentFile) {
        this.contentFile = contentFile;
    }

    public String getResumeDate() {
        return resumeDate;
    }

    public void setResumeDate(String resumeDate) {
        this.resumeDate = resumeDate;
    }
}
