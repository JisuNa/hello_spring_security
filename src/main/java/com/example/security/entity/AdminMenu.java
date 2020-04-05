package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name="ADMIN_MENU")
public class AdminMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger seq;
    public String url;
    @Column(name="is_deleted")
    public int is_deleted;
    @Column(name="created_at")
    public Date created_at;
}
