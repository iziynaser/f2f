package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "ACC_CURRENCY")
public class Currency extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "DESCRIPTION")
    private String description ;

}
