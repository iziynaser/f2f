package  com.f2f.entity.product;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "PARENT_PRODUCT_CATEGORY_ID")
    private ProductCategory parentProductCategory;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    public ProductCategory() {
    }

    public ProductCategory(String name, ProductCategory parentProductCategory, String fromDate, String toDate) {
        this.name = name;
        this.parentProductCategory = parentProductCategory;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id :"+ id +" ,");
        sb.append("name :"+ name +" , ");
        sb.append("parentCategory :"+ parentProductCategory +" , ");

        return sb.toString();
    }

}
