package com.f2f.entity.project;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
public class Project extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name="STATUS")
    private String status;

    @Column(name = "ACTUAL_START_DATE")
    private String actualStartDate;

    @Column(name = "ACTUAL_COMPLETE_DATE")
    private String actualCompleteDate;

    @Column(name = "ESTIMATE_COMPLETE_DATE")
    private String estimateCompleteDate;

    @Column(name = "PLANNED_HOURS")
    private String plannedHours;

    @Column(name = "ACTUAL_HOURS")
    private String actualHours;

    public Project() {
    }

    public Project( String name, String description, String status, String actualStartDate, String actualCompleteDate, String estimateCompleteDate, String plannedHours, String actualHours) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.actualStartDate = actualStartDate;
        this.actualCompleteDate = actualCompleteDate;
        this.estimateCompleteDate = estimateCompleteDate;
        this.plannedHours = plannedHours;
        this.actualHours = actualHours;
    }

    public String getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(String actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public String getActualCompleteDate() {
        return actualCompleteDate;
    }

    public void setActualCompleteDate(String actualCompleteDate) {
        this.actualCompleteDate = actualCompleteDate;
    }

    public String getEstimateCompleteDate() {
        return estimateCompleteDate;
    }

    public void setEstimateCompleteDate(String estimateCompleteDate) {
        this.estimateCompleteDate = estimateCompleteDate;
    }

    public String getPlannedHours() {
        return plannedHours;
    }

    public void setPlannedHours(String plannedHours) {
        this.plannedHours = plannedHours;
    }

    public String getActualHours() {
        return actualHours;
    }

    public void setActualHours(String actualHours) {
        this.actualHours = actualHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
