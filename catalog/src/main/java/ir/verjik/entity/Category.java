package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity implements Serializable {

    @Column(name = "CATEGORY_CODE")
    private String categoryCode;

    @Column(name = "NAME")
    private String name ;

    @Column(name = "slug")
    private String slug ;

    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private Category parentCategory;

    //@Column(name = "CATEGORY_TYPE")
    @OneToOne
    @JoinColumn(name = "CATEGORY_TYPE_ID")
    private CategoryType categoryType;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "DETAIL_IMAGE_URL")
    private String detailImageUrl;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "DISPLAY_ORDER")
    private Integer displayOrder;

    @Column(name = "LEVEL")
    private Integer level;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    private List<Category> subCategories = new ArrayList<>();

    public Category() {
    }

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
}

