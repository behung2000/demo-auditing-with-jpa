package com.example.demoauditingwithjpa.Auditing;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@Setter
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditListener.class)
public abstract class BaseAudit {
    @Column(name = "operation")
    private String operation;

    @Column(name = "timestamp")
    private Date timestamp;
}
