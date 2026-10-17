package ir.verjik.entity.entrance;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "VACATION_TYPE")
public class VacationType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;
}
