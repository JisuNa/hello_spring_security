package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADMINS")
public class Admins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name="account_id")
    private String accountId;
    private String name;
    private String role;
    private String password;
    @Column(name="is_deleted")
    private char isDeleted;
}
