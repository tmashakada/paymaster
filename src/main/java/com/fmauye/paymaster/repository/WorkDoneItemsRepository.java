/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fmauye.paymaster.repository;

import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.entity.WorkDoneItems;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F5437172
 */
@Repository
public interface WorkDoneItemsRepository extends JpaRepository< WorkDoneItems, Long>{
  @Query(
  value = "SELECT * FROM WorkDoneItems u WHERE u.work_done_id = ?1", 
  nativeQuery = true)
  List<WorkDoneItems> findbyWorkdoneid(Long id);
}
