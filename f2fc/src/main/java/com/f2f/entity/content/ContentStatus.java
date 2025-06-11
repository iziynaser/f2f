package com.f2f.entity.content;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CONTENT_STATUS")
public class ContentStatus extends BaseEntity implements Serializable {

    @Column(name = "STATUS")
    private String status ;

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content ;

    @Column(name = "MODIFY_DATE")
    private String modifyDate;

//    @OneToOne
//    @JoinColumn(name="USER_ACCOUNT_ID")
    private Long userAccountId;
}
