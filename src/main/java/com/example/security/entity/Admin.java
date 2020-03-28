package com.example.security.entity;

import lombok.Data;
import org.springframework.security.core.SpringSecurityCoreVersion;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADMIN")
public class Admin {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name="account_id")
    private String accountId;
    private String name;
    private String role;
    private String password;
    @Column(name="is_deleted")
    private int isDeleted = 0;
}
