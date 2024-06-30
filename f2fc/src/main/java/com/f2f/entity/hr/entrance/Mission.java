package com.f2f.entity.hr.entrance;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "MISSION")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MISSION_ID")
    private Integer id;

    @Column(name = "FROM_HOUR")
    private String fromHour ;

    @Column(name = "TO_HOUR")
    private String toHour ;

    @Column(name = "DESCRIPTION")
    private String description;

//    @Column(name = "PROJECT")
//    private Project project ;

    @Column(name = "REGISTER_DATE")
    private String registerDate ;

    @Column(name = "REQUESTER")
    private Person requester ;

}
