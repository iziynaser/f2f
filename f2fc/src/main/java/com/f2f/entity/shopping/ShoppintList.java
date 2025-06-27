package com.f2f.entity.shopping;




import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;

 

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppintList extends BaseEntity {

//    @GeneratedValue
//    @Column(name = "SHOPPING_LIST_ID")
//    private Integer shoppid;

    private String tagC;
}
