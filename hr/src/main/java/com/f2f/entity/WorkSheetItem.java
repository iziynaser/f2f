package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "WORK_SHEET_ITEM")
public class WorkSheetItem extends BaseEntity implements Serializable {

    @Column(name = "ENTRY_TIME")
    private String entryTime;

    @Column(name = "LEAVE_TIME")
    private String leaveTime;

    @ManyToOne
    @JoinColumn(name = "WORK_SHEET_ID")
    private WorkSheet workSheet;

}
