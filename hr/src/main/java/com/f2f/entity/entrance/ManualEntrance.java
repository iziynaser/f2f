package com.f2f.entity.entrance;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="MANUAL_ENTRANCE")
public class ManualEntrance extends BaseEntity {

    @Column(name = "REQUESTER")
    private PersonEntity Requester;

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
