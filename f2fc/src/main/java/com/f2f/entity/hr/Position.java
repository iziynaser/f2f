package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity implements Serializable {

    @Column(name="ESTIMATE_FROM_DATE")
    private Integer estimatedFromDate;

    @Column(name="ESTIMATE_TO_DATE")
    private Integer estimatedToDate;

    @Column(name="SALARY_FLAG")
    private Boolean salaryFlag ;

    @Column(name="FULL_TIME_FLAG")
    private Boolean fullTimeFlag;

    @Column(name="TEMP_FLAG")
    private Boolean TemporaryFlag;

    @Column(name="ACTUAL_FROM_DATE")
    private Integer actualFromDate;

    @Column(name="ACTUAL_TO_DATE")
    private Integer actualToDate;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private List<Responsibility> responsibilities = new ArrayList<Responsibility>();

    @ManyToOne
    private PersonEntity person;

    public Position() {
    }

    public Position(Integer estimatedFromDate, Integer estimatedToDate, Boolean salaryFlag, Boolean fullTimeFlag, Boolean temporaryFlag, Integer actualFromDate, Integer actualToDate) {
        this.estimatedFromDate = estimatedFromDate;
        this.estimatedToDate = estimatedToDate;
        this.salaryFlag = salaryFlag;
        this.fullTimeFlag = fullTimeFlag;
        TemporaryFlag = temporaryFlag;
        this.actualFromDate = actualFromDate;
        this.actualToDate = actualToDate;
    }
}
