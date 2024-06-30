package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LOGIN")
public class Login extends BaseEntity implements Serializable {

    @OneToOne(mappedBy = "login")
    private Person person;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="DATE_CREATED")
    private String dateCreated;

    @Column(name = "ENABLED")
    private String enabled;

    @Column(name = "LOCKED")
    private String locked ;

    @Column(name = "EXPIRED")
    private String expired;

    @Column(name = "EXPIRE_DATE")
    private String expireDate;

    @Column(name="LOCALES")
    private String locale ;

    @Column(name = "PASSWORD_HINT")
    private String passwordHint;

    private Boolean requirePasswordChange;

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public Boolean getRequirePasswordChange() {
        return requirePasswordChange;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setRequirePasswordChange(Boolean requirePasswordChange) {
        this.requirePasswordChange = requirePasswordChange;
    }

    public Login() {
    }

    public Login(Person person, String userName, String password, String dateCreated, String enabled, String locked, String expired, String expireDate, String locale, String passwordHint, Boolean requirePasswordChange) {
        this.person = person;
        this.userName = userName;
        this.password = password;
        this.dateCreated = dateCreated;
        this.enabled = enabled;
        this.locked = locked;
        this.expired = expired;
        this.expireDate = expireDate;
        this.locale = locale;
        this.passwordHint = passwordHint;
        this.requirePasswordChange = requirePasswordChange;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
//        sb.append("id "+ id +",");
        sb.append("person " + person + ",");
        sb.append("userName " + userName + ",");
        sb.append("dateCreated " + dateCreated + ",");
        sb.append("enabled " + enabled + ",");
        sb.append("locked " + locked + ",");
        sb.append("expired " + expired + ",");
        sb.append("locale " + locale + ",");

        return sb.toString();
    }
}
