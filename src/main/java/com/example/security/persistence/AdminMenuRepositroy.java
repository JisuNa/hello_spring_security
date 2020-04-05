package com.example.security.persistence;


import com.example.security.entity.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMenuRepositroy extends JpaRepository<AdminMenu, Long> {
}
