package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
//@Table(indexes = {@Index(name = "index_username", columnList = "username")})
@Table()
public class LoginHistoryEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -7088423724470075317L;
    /**
     * 用于记录用户在哪个子系统进行的登陆
     */
    private String clientId;
    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String username;
    private String ipAddress;
    private String device;

    private LocalDateTime loginTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccountEntity user;

    @Column(nullable = false)
    private boolean successful;

    @Column(nullable = true)
    private String failureReason;

}
