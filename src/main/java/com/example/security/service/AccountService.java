package com.example.security.service;

import com.example.security.entity.Admin;

public interface AccountService {

    public Admin joinAccount(Admin admins);
    public Admin getAccountByAccountId(String account_id);
    public void createAccount(Admin account);

}
