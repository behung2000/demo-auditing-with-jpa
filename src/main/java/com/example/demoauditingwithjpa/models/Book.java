package com.example.demoauditingwithjpa.models;

import com.example.demoauditingwithjpa.Auditing.AuditListener;
import com.example.demoauditingwithjpa.Auditing.BaseAudit;
import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditListener.class)
@Table(schema = "test_audit_with_jpa", name = "book")
public class Book extends BaseAudit {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "is_active")
    private boolean isActive;

    public String toString() {
        return new Gson().toJson(this);
    }

    //Auditing
    /*

    @Column(name = "operation")
    private String operation;

    @Column(name = "timestamp")
    private Date timestamp;


    /*
    @PrePersist
    public void onPrePersist() {
        audit("INSERT");
    }

    @PreUpdate
    public void onPreUpdate() {
        audit("UPDATE");
    }

    @PreRemove
    public void onPreRemove() {
        audit("DELETE");
    }

    private void audit(String operation) {
        setOperation(operation);
        setTimestamp((new Date()));
    }
     */

    private static void test() {
        System.out.println("test 123");
    }
}
