package com.f2f.persisence;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"clientId"}))
public class OauthClientEntity extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -3042356579574873614L;
    @Column(nullable = false)
    private String clientId;
    private String applicationName;
    private String resourceIds;
    @Column(nullable = false)
    private String clientSecret;
    private String scope;
    @Column(nullable = false)
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    @Column(nullable = false)
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoApprove;
    /**
     * 客户端过期时间，比如应用于多店系统
     */
    private LocalDateTime expirationDate;

}
