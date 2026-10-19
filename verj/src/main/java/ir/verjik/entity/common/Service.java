package ir.verjik.entity.common;


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
@Table(name = "SERVICE")
public class Service extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    //@ManyToMany(mappedBy = "services")
    //private Collection<Group> groups;

    public Service() {
    }
}
