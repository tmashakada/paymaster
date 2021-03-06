/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.repository;

import com.fmauye.paymaster.entity.ConfirmationToken;
import com.fmauye.paymaster.entity.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author "Tafadzwa"
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Optional<Department> findDepartmentByDescriptionIgnoreCase(String name);
}
