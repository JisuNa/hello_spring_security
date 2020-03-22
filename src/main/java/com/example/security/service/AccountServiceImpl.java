package com.example.security.service;

import com.example.security.entity.Admins;
import com.example.security.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Admins joinAccount(Admins admins) {
        admins.setRole("ROLE_ADMIN");
        admins.setName("어드민");
        admins.setPassword(passwordEncoder.encode(admins.getPassword()));
        return accountRepository.save(admins);
    }

    @Override
    public Admins getAccountByAccountId(String account_id) {
        return accountRepository.findByAccountId(account_id);
    }

    @Override
    public void createAccount(Admins account) {
        accountRepository.save(account);
    }
}
