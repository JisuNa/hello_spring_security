package com.example.security.persistence;

import com.example.security.entity.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MenuRoleRepository extends JpaRepository<MenuRole, BigInteger> {

    MenuRole findByAdminSeqAndMenuSeq(BigInteger admin_seq, BigInteger menu_seq);

}
