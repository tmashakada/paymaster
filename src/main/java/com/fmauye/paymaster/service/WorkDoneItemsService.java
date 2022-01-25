/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.WorkDoneItems;
import com.fmauye.paymaster.repository.WorkDoneItemsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5437172
 */
@Service
public class WorkDoneItemsService {
    @Autowired
    private WorkDoneItemsRepository workDoneItemsRepository;
    
    public List<WorkDoneItems> getWorkDoneItemsByWorkDoneId(Long workdoneid){
     return   workDoneItemsRepository.findbyWorkdoneid(1L);
    }
}
