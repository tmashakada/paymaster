/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.repository.WorkDoneRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5437172
 */
@Service
public class WorkDoneService {
    @Autowired
    private WorkDoneRepository workDoneRepository;
    
   public  List<WorkDone> getAllByUserName(String username){
        
        return workDoneRepository.findByUsernameIgnoreCase(username);
       
        
        
    }
   public  List<WorkDone> getAllByUserNameAndStatus(String username,String status){
        
        return workDoneRepository.findBySubmittedByAndStatus(username, status);
        
    }
    public  List<WorkDone> getAllByDepartmentAndStatus(String department,String status){
        
        return workDoneRepository.findByDepartmentAndStatus(department, status);
        
    }
    public  List<WorkDone> getAllByDepartment(String department){
        
        return workDoneRepository.findByDepartment(department);
        
    }
    
    public  List<WorkDone> getAllByStatus(String status){
        
        return workDoneRepository.findByStatusIgnoreCase(status);
        
    }
    public boolean update(Long id,String username,String status){
     Optional< WorkDone > workdoneopt=   workDoneRepository.findById(id);
   
     WorkDone newworkdone=workdoneopt.get();
     newworkdone.setStatus(status);
     newworkdone.setUsername(username);
     newworkdone.setUpdatedAt(LocalDateTime.now());
     workDoneRepository.save(newworkdone);
      return true;
    }
   
}
