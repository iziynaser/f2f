package com.f2f.entity.shopping;




import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppintList extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "SHOPPING_LIST_ID")
    private Integer id;

}
