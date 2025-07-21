package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.eums.ContentStatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CONTENT_STATUS")
public class ContentStatus extends BaseEntity implements Serializable {

    @Column(name = "STATUS")
    private ContentStatusType status ;

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content ;

    @Column(name = "MODIFY_DATE")
    @UpdateTimestamp
    private LocalDateTime modifyDate;

//    @OneToOne
//    @JoinColumn(name="USER_ACCOUNT_ID")
    private Long userAccountId;
}
