package ir.verjik.entity.entrance;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.entity.PersonEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "VACATION")
public class Vacation extends BaseEntity {

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name = "REGISTER_DATE")
    private String registerDate ;

    @Column(name = "REQUESTER")
    private PersonEntity requester;

    @Column(name ="FROM_HOUR")
    private String fromHour;

    @Column(name ="TO_HOUR")
    private String toHour ;

    @Column(name ="VACTION_TYPE_ID")
    private VacationType vacationType;
}
