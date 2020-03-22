package com.example.security.controller;

import com.example.security.entity.Admins;
import com.example.security.persistence.AccountRepository;
import com.example.security.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {

    private AccountRepository accountRepository;
    private AccountService accountService;

    public IndexController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping(value="")
    public String index(Model model, Principal principal) {
//        Admins admins = (Admins) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("accountId", admins.getAccountId());
//        model.addAttribute("name", admins.getName());
//        model.addAttribute("role", admins.getRole());

        model.addAttribute("name",principal.getName());

        return "index";
    }

    @GetMapping(value="/account/list")
    public ResponseEntity<?> accountList() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }

    // 회원가입 페이지
    @GetMapping(value="/join")
    public String joinPage() {
        return "auth/join";
    }

    // 회원가입하기
    @PostMapping(value="/join")
    public String joinAction(@ModelAttribute Admins admins) {
        accountService.joinAccount(admins);
        return "login";
    }

    @GetMapping(value="/login")
    public String loginPage() {
        return "auth/login";
    }

//    @PostMapping(value="/login/action")
//    public String loginAction() {
//
//    }
}