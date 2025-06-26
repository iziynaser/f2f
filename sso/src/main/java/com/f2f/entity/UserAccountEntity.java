package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class UserAccountEntity extends BaseEntity {

    private static final long serialVersionUID = -5519234457588411587L;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String username;
    @Column(nullable = false)
    private String password;
    /**
     * multiple login methods to merge account use
     */
    private String accountOpenCode;

    private LocalDateTime failureTime;
    @Column(name = "failure_count", columnDefinition = "int default 0")
    private int failureCount;

//    @OneToOne(mappedBy = "login")
    private Long personLoginId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name="DATE_CREATED")
    private LocalDateTime dateCreated;

    @Column(name = "ENABLED")
    private Boolean  enabled;

    @Column(name = "LOCKED")
    private Boolean  locked ;

    @Column(name = "EXPIRED")
    private Boolean  expired;

    @Column(name = "EXPIRE_DATE")
    private LocalDateTime expireDate;

    @Column(name="LOCALES")
    private String locale ;

    @Column(name = "PASSWORD_HINT")
    private String passwordHint;

    private Boolean requirePasswordChange;

//    @OneToOne(fetch = FetchType.LAZY)
    private Long personId;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Set<RoleEntity> roles = new HashSet<RoleEntity>();

}