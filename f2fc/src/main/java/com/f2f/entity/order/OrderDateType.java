package com.f2f.entity.order;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.Column;
import java.io.Serializable;

public class OrderDateType extends BaseEntity implements Serializable {

    @Column(name = "ORDER_DATE_TYPE_NAME")
    private String name;


}
