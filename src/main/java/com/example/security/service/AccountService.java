package com.example.security.service;

import com.example.security.entity.Accounts;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {

    public Accounts joinAccount();
    public Accounts getAccountByAccountId(String account_id);
    public void createAccount(Accounts account);

}
