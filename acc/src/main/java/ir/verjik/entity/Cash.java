package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CASH")
public class Cash extends BaseEntity {

    public Cash() {
    }


}
