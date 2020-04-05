package com.example.security.controller;

import com.example.security.entity.Admin;
import com.example.security.persistence.AdminRepository;
import com.example.security.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class IndexController {

    private AdminRepository accountRepository;
    private AccountService accountService;

    public IndexController(AdminRepository accountRepository, AccountService accountService) {
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

    // 회원가입 페이지
    @GetMapping(value="/join")
    public String joinPage() {
        return "auth/join";
    }

    // 회원가입하기
    @PostMapping(value="/join")
    public String joinAction(@ModelAttribute Admin admins) {
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