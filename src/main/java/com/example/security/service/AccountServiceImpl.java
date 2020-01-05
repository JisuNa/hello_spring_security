package com.example.security.service;

import com.example.security.entity.Accounts;
import com.example.security.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    @Override
    public Accounts joinAccount() {
        Accounts accounts = new Accounts();
        accounts.setAccountId("admin");
        accounts.setRole("ADMIN");
        accounts.setName("어드민");
        accounts.setPassword(passwordEncoder.encode("1111"));
        return accountRepository.save(accounts);
    }

    @Override
    public UserDetails loadUserByUsername(String account_id) throws UsernameNotFoundException {
        Accounts accounts = accountRepository.findByAccountId(account_id);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(accounts.getRole()))
        return new User(accounts.getAccountId(), accounts.getPassword(), authorities);
    }

    @Override
    public Accounts getAccountByAccountId(String account_id) {
        return accountRepository.findByAccountId(account_id);
    }

    @Override
    public void createAccount(Accounts account) {
        accountRepository.save(account);
    }
}
