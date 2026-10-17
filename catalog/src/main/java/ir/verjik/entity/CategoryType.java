package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY_TYPE",uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class CategoryType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SLUG")
    private String slug;

    @Column(name = "ICON")
    private String iconUrl;

    public CategoryType() {
    }

    public CategoryType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
