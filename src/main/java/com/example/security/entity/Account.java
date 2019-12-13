package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String account_id;
    private String password;
    private char is_deleted;
}
