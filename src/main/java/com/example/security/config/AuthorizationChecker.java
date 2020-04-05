package com.example.security.config;

import com.example.security.entity.Admin;
import com.example.security.entity.AdminMenu;
import com.example.security.entity.MenuRole;
import com.example.security.persistence.AdminMenuRepositroy;
import com.example.security.persistence.AdminRepository;
import com.example.security.persistence.MenuRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.math.BigInteger;

@Component
public class AuthorizationChecker {

    private AdminRepository adminRepository;
    private AdminMenuRepositroy adminMenuRepository;
    private MenuRoleRepository menuRoleRepository;

    public AuthorizationChecker(MenuRoleRepository menuRoleRepository, AdminRepository adminRepository, AdminMenuRepositroy adminMenuRepository) {
        this.menuRoleRepository = menuRoleRepository;
        this.adminRepository = adminRepository;
        this.adminMenuRepository = adminMenuRepository;
    }

    public boolean check(HttpServletRequest request, Authentication authentication) {

        Object pricipalObj = authentication.getPrincipal();

        if(!(pricipalObj instanceof User)) {
            return false;
        }

        int authority = 0;

        BigInteger adminSeq = adminRepository.findByAccountId(((User) pricipalObj).getUsername()).getSeq();

        for (AdminMenu adminMenu : adminMenuRepository.findAll()) {
            System.out.println(adminMenu.getUrl()+" | "+request.getRequestURI());
            if(new AntPathMatcher().match(adminMenu.getUrl(), request.getRequestURI())) {
                MenuRole menuRole = menuRoleRepository.findByAdminSeqAndMenuSeq(adminSeq, adminMenu.getSeq());
                authority = menuRole.getAuthority();
                break;
            }
        }

        System.out.println(authority);
//        String userId = ((User) authentication.getPrincipal()).getUserId();
//        User loggedUser = userRepository.findByUserId(userId);
//
//        List<String> authorities = loggedUser.getAuthority();
//
//        if (authority == null || !authorities.contains(authority)) {
//            return false;
//        }

        return true;
    }

}
