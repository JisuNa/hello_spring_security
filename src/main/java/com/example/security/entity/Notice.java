package com.example.security.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="NOTICE")
@Where(clause="is_deleted=0")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long seq;
    public String title;
    public String content;
    @Column(name="admin_seq")
    public Long admin_seq;
    public Long hit;
    @Column(name="created_at")
    public Date created_at;
    @Column(name="is_deleted")
    public int is_deleted;

}
