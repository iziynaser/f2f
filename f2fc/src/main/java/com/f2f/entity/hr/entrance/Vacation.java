package com.f2f.entity.hr.entrance;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "VACATION")
public class Vacation extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "VACATION")
    private Integer id;

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name = "REGISTER_DATE")
    private String registerDate ;

    @Column(name = "REQUESTER")
    private Person requester;

    @Column(name ="FROM_HOUR")
    private String fromHour;

    @Column(name ="TO_HOUR")
    private String toHour ;

    @Column(name ="VACTION_TYPE_ID")
    private VacationType vacationType;
}
