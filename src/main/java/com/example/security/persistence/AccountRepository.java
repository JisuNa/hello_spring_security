package com.example.security.persistence;

import com.example.security.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

    Accounts findByAccountId(String account_id);
}
