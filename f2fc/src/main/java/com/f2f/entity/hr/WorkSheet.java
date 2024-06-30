package com.f2f.entity.hr;


import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WORK_SHEET")
public class WorkSheet extends BaseEntity implements Serializable {

    @ManyToOne
    private Person person;

    @Column(name = "YEAR")
    private int year ;

    @Column(name = "MONTH")
    private int month;

    @Column(name = "DAY")
    private int day;

    @OneToMany(mappedBy = "workSheet",cascade = CascadeType.ALL)
    private List<WorkSheetItem> workSheetItems = new ArrayList<WorkSheetItem>();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<WorkSheetItem> getWorkSheetItems() {
        return workSheetItems;
    }

    public void setWorkSheetItems(List<WorkSheetItem> workSheetItems) {
        this.workSheetItems = workSheetItems;
    }

    public WorkSheet() {
    }


}
