package com.f2f.entity.hr;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WORK_SHEET_ITEM")
public class WorkSheetItem extends BaseEntity implements Serializable {

    @Column(name = "ENTRY_TIME")
    private String entryTime;

    @Column(name = "LEAVE_TIME")
    private String leaveTime;

    private WorkSheet workSheet;

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public WorkSheetItem() {
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }

    public void setWorkSheet(WorkSheet workSheet) {
        this.workSheet = workSheet;
    }
}
