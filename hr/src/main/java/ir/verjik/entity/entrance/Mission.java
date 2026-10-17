package ir.verjik.entity.entrance;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;


@Entity
@Table(name = "MISSION")
public class Mission extends BaseEntity {

    @Column(name = "FROM_HOUR")
    private String fromHour ;

    @Column(name = "TO_HOUR")
    private String toHour ;

    @Column(name = "DESCRIPTION")
    private String description;

//    @Column(name = "PROJECT")
//    private Project project ;

    @Column(name = "REGISTER_DATE")
    private String registerDate ;

    @Column(name = "REQUESTER")
    private Long requesterPersonId ;

}
