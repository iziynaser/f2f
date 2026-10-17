package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "INVOICE_ROLE")
public class InvoiceRole extends BaseEntity {
    //نقش اشخصاص روی فاکتور

}
