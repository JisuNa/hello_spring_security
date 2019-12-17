package com.example.security.service;

import com.example.security.entity.Account;
import com.example.security.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account getAccountByAccountId(String account_id) {
        return accountRepository.findByAccount_id(account_id);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}
