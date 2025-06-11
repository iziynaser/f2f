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
@Table(name = "EVENT")
public class Event extends BaseEntity implements Serializable {

    @Column(name = "EVENT_PERSON_FROM")
    private PersonEntity fromPerson;

    @Column(name = "EVENT_PERSON_TO")
    private PersonEntity toPerson;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_TIME")
    private String endTime;

    @Column(name = "DURATION")
    private String duration;
}
