package com.f2f.persisence;

import com.f2f.dbc.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "password_policy")
public class PasswordPolicyEntity extends BaseEntity {

    @Column(nullable = false)
    private int minLength;

    @Column(nullable = false)
    private boolean requireUppercase;

    @Column(nullable = false)
    private boolean requireLowercase;

    @Column(nullable = false)
    private boolean requireNumber;

    @Column(nullable = false)
    private boolean requireSpecialChar;

    @Column(nullable = false)
    private int passwordExpiryDays;

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // بررسی حداقل طول
        if (password.length() < minLength) {
            return false;
        }

        // اگر باید حرف بزرگ باشد
        if (requireUppercase && !password.chars().anyMatch(Character::isUpperCase)) {
            return false;
        }

        // اگر باید حرف کوچک باشد
        if (requireLowercase && !password.chars().anyMatch(Character::isLowerCase)) {
            return false;
        }

        // اگر باید عدد داشته باشد
        if (requireNumber && !password.chars().anyMatch(Character::isDigit)) {
            return false;
        }

        // اگر باید کاراکتر خاص داشته باشد (نمادهای غیر حرف و عدد)
        if (requireSpecialChar && password.chars().noneMatch(ch -> !Character.isLetterOrDigit(ch))) {
            return false;
        }

        // اگر همه شرایط برقرار بودند
        return true;
    }

}
