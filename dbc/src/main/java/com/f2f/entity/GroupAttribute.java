package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "GROUP_ATTRIBUTE")
public class GroupAttribute extends BaseEntity implements Serializable {

    @Column(name = "ATTRIBUTE_ID")
    private Group group;

    @Column(name = "ATTRIBUTE_NAME")
    private String attributeName ;

    @Column(name = "ATTRIBUTE_VALUE")
    private String attributeValue ;

    public GroupAttribute(){
        //
    }

    public GroupAttribute( Group group, String attributeName, String attributeValue) {
        //this.id = id;
        this.group = group;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

}
