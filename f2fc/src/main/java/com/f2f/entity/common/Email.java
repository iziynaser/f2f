package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//@JsonAutoDetect
@Entity
@Table(name = "EMAIL")
public class Email extends BaseEntity implements Serializable {

    @Column(name = "EMAILAD")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Email(){

    }
    public Email(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id :"+ id +" ,");
        sb.append("email :"+ email +" , ");
        sb.append("name :"+ name +" , ");
        sb.append("phone:"+ phone + " , ");

        return sb.toString();

    }
}
