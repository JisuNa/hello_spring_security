package com.example.security.service;

import com.example.security.entity.Admins;

public interface AccountService {

    public Admins joinAccount();
    public Admins getAccountByAccountId(String account_id);
    public void createAccount(Admins account);

}
