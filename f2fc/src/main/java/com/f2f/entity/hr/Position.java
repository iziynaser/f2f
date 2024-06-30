package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private Person person;

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

    public Integer getEstimatedFromDate() {
        return estimatedFromDate;
    }

    public void setEstimatedFromDate(Integer estimatedFromDate) {
        this.estimatedFromDate = estimatedFromDate;
    }

    public Integer getEstimatedToDate() {
        return estimatedToDate;
    }

    public void setEstimatedToDate(Integer estimatedToDate) {
        this.estimatedToDate = estimatedToDate;
    }

    public Boolean getSalaryFlag() {
        return salaryFlag;
    }

    public void setSalaryFlag(Boolean salaryFlag) {
        this.salaryFlag = salaryFlag;
    }

    public Boolean getFullTimeFlag() {
        return fullTimeFlag;
    }

    public void setFullTimeFlag(Boolean fullTimeFlag) {
        this.fullTimeFlag = fullTimeFlag;
    }

    public Boolean getTemporaryFlag() {
        return TemporaryFlag;
    }

    public void setTemporaryFlag(Boolean temporaryFlag) {
        TemporaryFlag = temporaryFlag;
    }

    public Integer getActualFromDate() {
        return actualFromDate;
    }

    public void setActualFromDate(Integer actualFromDate) {
        this.actualFromDate = actualFromDate;
    }

    public Integer getActualToDate() {
        return actualToDate;
    }

    public void setActualToDate(Integer actualToDate) {
        this.actualToDate = actualToDate;
    }

    public List<Responsibility> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<Responsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
