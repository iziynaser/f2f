package com.f2f.entity.content;

<<<<<<< Updated upstream:src/main/java/com/f2f/entity/content/ContentStatus.java
import com.revengemission.sso.oauth2.server.domain.UserAccount;
import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.revengemission.sso.oauth2.server.persistence.entity.UserAccountEntity;
=======
import com.f2f.persistance.entity.*;

>>>>>>> Stashed changes:f2f/src/main/java/com/f2f/entity/content/ContentStatus.java

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTENT_STATUS")
public class ContentStatus extends BaseEntity implements Serializable {

    @Column(name = "STATUS")
    private String status ;

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content ;

    @Column(name = "MODIFY_DATE")
    private String modifyDate;

    @OneToOne
    @JoinColumn(name="USER_ACCOUNT_ID")
    private UserAccountEntity userAccount;

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
