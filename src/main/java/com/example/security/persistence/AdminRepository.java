package com.example.security.persistence;

import com.example.security.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AdminRepository extends JpaRepository<Admin, BigInteger> {

    Admin findByAccountId(String account_id);
}
