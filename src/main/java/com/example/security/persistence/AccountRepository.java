package com.example.security.persistence;

import com.example.security.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccount_id(String account_id);
}
