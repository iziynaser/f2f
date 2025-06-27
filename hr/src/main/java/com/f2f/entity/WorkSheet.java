package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "WORK_SHEET")
public class WorkSheet extends BaseEntity implements Serializable {

    @ManyToOne
    private PersonEntity person;

    @Column(name = "YEAR")
    private int year ;

    @Column(name = "MONTH")
    private int month;

    @Column(name = "DAY")
    private int day;

    @OneToMany(mappedBy = "workSheet",cascade = CascadeType.ALL)
    private List<WorkSheetItem> workSheetItems = new ArrayList<WorkSheetItem>();

}
