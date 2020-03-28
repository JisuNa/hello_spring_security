package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long seq;
    @Column(name="user_email")
    public String user_email;
    public String password;
    public int gender;
    @Column(name="is_deleted")
    public int is_deleted;
    @Column(name="created_at")
    public Date created_at;
    @Column(name="updated_at")
    public Date updated_at;

}
