/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.exception.ResourceNotFoundException;
import com.fmauye.paymaster.service.ItemServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author F5437172
 */

@Named
@RequestScoped
public class ItemView {
    private Item item;
    private List<Item> items;
    private BigDecimal amount = BigDecimal.valueOf(0);
    private String itemdescription;
    
    @Autowired
    ItemServiceImpl itemServiceImpl;
    
    
    @PostConstruct
    public void init() {
        
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItems() {
        
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void save (){
        try{
        Item itemnew=new Item();
        itemnew.setAmount(amount);
        itemnew.setDescription(itemdescription);
       
        if (amount.compareTo(BigDecimal.ZERO) > 0){
             
          Item createditem=     itemServiceImpl.createItem(itemnew);
          amount= BigDecimal.valueOf(0);
          itemdescription="";
          FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Created Successful New Item "+createditem.getDescription()));
         }else{
              FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Please Enter Amount"));
          }
        }catch(ResourceNotFoundException ex){
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",  ex.getMessage()));
        }
    }
    
}
