package com.example.security.service;

import com.example.security.entity.Account;

public interface AccountService {

    public Account getAccountByAccountId(String account_id);
    public void createAccount(Account account);

}
