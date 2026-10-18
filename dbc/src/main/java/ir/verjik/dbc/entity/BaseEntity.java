package ir.verjik.dbc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;


import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@RequiredArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_status", columnDefinition = "int default 0")
    private int recordStatus;

    @Version
    @Column(name = "version", columnDefinition = "int default 0")
    private int version;

    private String remarks;

    @Column(name = "sort_priority", columnDefinition = "int default 0")
    private int sortPriority;

    //@Column(columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    //@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP")
    @Column(name="last_modified")
    @UpdateTimestamp
    private LocalDateTime lastModified;

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setSortPriority(int sortPriority) {
        this.sortPriority = sortPriority;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastModified = LocalDateTime.now();
        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}
