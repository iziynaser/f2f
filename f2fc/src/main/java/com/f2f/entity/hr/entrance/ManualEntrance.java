package com.f2f.entity.hr.entrance;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="MANUAL_ENTRANCE")
public class ManualEntrance extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MANUAL_ENTRANCE_ID")
    private Integer id;

    @Column(name = "REQUESTER")
    private Person Requester;

    @Column(name = "ENTRY_TIME")
    private String entryTime ;

    @Column(name = "EXIT_TIME")
    private String exitTime;

    @Column(name = "DATES")
    private String dates;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REGISTER_DATE")
    private String registerDate ;

}
