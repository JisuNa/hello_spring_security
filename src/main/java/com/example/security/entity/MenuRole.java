package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name="MENU_ROLE")
public class MenuRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger seq;
    @Column(name="admin_seq")
    public Long adminSeq;
    @Column(name="menu_seq")
    public Long menuSeq;
    public int authority;
    @Column(name="created_at")
    public Date created_at;

}
