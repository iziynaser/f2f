package com.f2f.entity.order;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_STATUS_TYPE")
public class OrderStatusType extends BaseEntity implements Serializable  {

    //jari , tahvilshode , marjooee , laghvshode ,

    @Column(name = "STATUS_NAME")
    private String name;

}
