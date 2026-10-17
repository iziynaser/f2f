package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private Long personId;

}
