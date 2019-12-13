package com.example.security.api;

import com.example.security.persistence.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountApiController {

    final AccountRepository accountRepository;

    public AccountApiController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }



}