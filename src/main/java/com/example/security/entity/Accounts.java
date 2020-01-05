package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String accountId;
    private String name;
    private String role;
    private String password;
    private char isDeleted;
}
