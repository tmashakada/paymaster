/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.entity.WorkDoneItemsTemp;
import com.fmauye.paymaster.repository.ItemRepository;
import com.fmauye.paymaster.repository.UsersRepository;
import com.fmauye.paymaster.service.WorkDoneItemsTempService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author F5437172
 */
@Named
@RequestScoped
public class WorkDoneItemsTempController {
    
    @Autowired
    private  WorkDoneItemsTempService workDoneItemsTempService;
    
  
    
    private int qty;
    private String username;
    @PostConstruct
    public void init() {
        
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void  saveTemp(Item item){
        WorkDoneItemsTemp temp=new WorkDoneItemsTemp();
        temp.setAmount(item.getAmount());
        temp.setCreatedAt(LocalDateTime.now());
        temp.setItem(item.getId().intValue());
        temp.setUpdatedAt(LocalDateTime.now());
       
        BigDecimal itemCost  = item.getAmount().multiply(BigDecimal.valueOf(qty));
        temp.setTotalamount(itemCost);
        temp.setQty(qty);
        temp.setUsername(username);
        workDoneItemsTempService.create(temp);
    }
     public void  save(){
     
      
     }
}
