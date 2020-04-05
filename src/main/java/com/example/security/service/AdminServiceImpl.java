package com.example.security.service;

import com.example.security.entity.Admin;
import com.example.security.persistence.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AccountService {

    private PasswordEncoder passwordEncoder;
    private final AdminRepository accountRepository;

    @Autowired
    public AdminServiceImpl(PasswordEncoder passwordEncoder, AdminRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Admin joinAccount(Admin admins) {
        admins.setRole("ROLE_ADMIN");
        admins.setName("어드민");
        admins.setPassword(passwordEncoder.encode(admins.getPassword()));
        return accountRepository.save(admins);
    }

    @Override
    public Admin getAccountByAccountId(String account_id) {
        return accountRepository.findByAccountId(account_id);
    }

    @Override
    public void createAccount(Admin account) {
        accountRepository.save(account);
    }
}
