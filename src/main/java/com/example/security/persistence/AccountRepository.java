package com.example.security.persistence;

import com.example.security.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Admin, Long> {

    Admin findByAccountId(String account_id);
}
