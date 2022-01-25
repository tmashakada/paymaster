/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fmauye.paymaster.repository;

import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.entity.WorkDoneItemsTemp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author F5437172
 */
@Repository
public interface WorkDoneRepository extends JpaRepository<WorkDone, Long>{
    List<WorkDone> findBySubmittedByAndStatus(String username,String status);
     List<WorkDone> findByDepartmentAndStatus(String department,String status);
     List<WorkDone> findByDepartment(String department);
     List<WorkDone> findByStatusIgnoreCase(String name);
     List<WorkDone> findByUsernameIgnoreCase(String name);
     
}
