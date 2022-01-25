/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.entity.WorkDoneItems;
import com.fmauye.paymaster.entity.WorkDoneItemsTemp;
import com.fmauye.paymaster.exception.ResourceNotFoundException;
import com.fmauye.paymaster.repository.ItemRepository;
import com.fmauye.paymaster.repository.UsersRepository;
import com.fmauye.paymaster.repository.WorkDoneItemsRepository;
import com.fmauye.paymaster.repository.WorkDoneItemsTempRepository;
import com.fmauye.paymaster.repository.WorkDoneRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5437172
 */
@Service
public class WorkDoneItemsTempService {
    @Autowired
    private WorkDoneItemsTempRepository tempRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private WorkDoneRepository workDoneRepository;
    @Autowired
    private WorkDoneItemsRepository workDoneItemsRepository;
    
    public WorkDoneItemsTemp create(WorkDoneItemsTemp temp){
         Optional<WorkDoneItemsTemp> tempOpt=tempRepository.findByUsernameAndDescription(temp.getUsername(),temp.getDescription());
       if(tempOpt.isPresent())
          throw new ResourceNotFoundException("Item Already Added  with id "+temp.getDescription()) ;
        
        return this.tempRepository.save(temp);
        
    }
    public List<WorkDoneItemsTemp> getAll(String username){
        return  tempRepository.findByUsernameIgnoreCase(username);
    }
    
    public void deleteTemp(WorkDoneItemsTemp temp){
       
    	
    	this.tempRepository.delete(temp);
    }
    public void deleteAllTemp(List<WorkDoneItemsTemp> temps){
       
    	
    	this.tempRepository.deleteAll(temps);
    }
    public List<WorkDoneItemsTemp> getAllByUserName(String username){
      
        return  this.tempRepository.findByUsernameIgnoreCase(username);
   }
    
    public  WorkDone saveWorkDone(String username){
         List<WorkDoneItemsTemp> tempList=   getAll(username);
         Optional<Users> useropt=usersRepository.findByUserNameIgnoreCase(username);
         
         WorkDone workDone=new WorkDone();
         workDone.setCreatedAt(LocalDateTime.now());
         workDone.setUpdatedAt(LocalDateTime.now());
         workDone.setDepartment(useropt.get().getDepartment().getDescription());
         workDone.setSubmittedBy(useropt.get().getUserName());
         workDone.setStatus("PENDING");
         workDone.setUsername(username);
       WorkDone newworkdone=  workDoneRepository.save(workDone);
       List<WorkDoneItems> workDoneItemsList=new ArrayList<>();
      for(WorkDoneItemsTemp temp:tempList){
          Optional<Item> itemopt=itemRepository.findItemByDescriptionIgnoreCase(temp.getDescription());
         // Item item =new Item();
          WorkDoneItems workDoneItems=new WorkDoneItems();
          workDoneItems.setAmount(temp.getAmount());
          workDoneItems.setQty(temp.getQty());
          workDoneItems.setTotalamount(temp.getTotalamount());
          workDoneItems.setItem(itemopt.get());
          workDoneItems.setCreatedAt(LocalDateTime.now());
          workDoneItems.setUpdatedAt(LocalDateTime.now());
          workDoneItems.setWorkdone(newworkdone);
          workDoneItemsList.add(workDoneItems);
          
          
          
      }
      workDoneItemsRepository.saveAll(workDoneItemsList);
      //Delete from
      
    	this.tempRepository.deleteAll(tempList);
      
        return newworkdone;
      
      
    }
    
}
