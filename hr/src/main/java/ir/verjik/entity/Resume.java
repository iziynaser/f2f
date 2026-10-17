package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


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

    private Long personId;

}
