/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fmauye.paymaster.entity.Item;
import java.util.Optional;
/**
 *
 * @author F5437172
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    Optional<Item> findItemByDescriptionIgnoreCase(String name); 
}
