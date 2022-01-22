/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.repository;

import com.fmauye.paymaster.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author "Tafadzwa"
 */
@Repository
//@Transactional(readOnly = true)
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUserNameIgnoreCase(String username);
    @Transactional
    @Modifying
    @Query("UPDATE Users u SET u.enabled=true WHERE u.email=?1")
    int enableAppUser(String email);
}
