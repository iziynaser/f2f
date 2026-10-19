package ir.verjik.entity.other;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class EmailTypeEntity extends BaseEntity implements Serializable {
    private String name;
    private String type;

}
