package com.example.demoauditingwithjpa.Auditing;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.util.Date;

public class AuditListener {
    @PrePersist
    private void beforeCreate(BaseAudit baseAudit) {
        baseAudit.setOperation("Created");
        baseAudit.setTimestamp(new Date());
    }
    @PreUpdate
    private void beforeUpdate(BaseAudit baseAudit) {
        baseAudit.setOperation("Update");
        baseAudit.setTimestamp(new Date());
    }

    @PreRemove
    private void beforeDelete(BaseAudit baseAudit) {
        baseAudit.setOperation("Delete");
        baseAudit.setTimestamp(new Date());
    }
}
