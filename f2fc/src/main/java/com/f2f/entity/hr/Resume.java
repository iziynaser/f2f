package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "RESUME")
public class Resume extends BaseEntity implements Serializable {

    @Column(name = "CONTENT_FILE")
    private String contentFile ;

    @Column(name = "RESUME_DATE")
    private String resumeDate ;

    private PersonEntity person;

    public Resume() {
    }

    public Resume(String contentFile, String resumeDate) {
        this.contentFile = contentFile;
        this.resumeDate = resumeDate;
    }
}
