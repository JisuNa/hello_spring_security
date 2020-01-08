package com.example.security.persistence;

import com.example.security.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Admins, Long> {

    Admins findByAccountId(String account_id);
}
