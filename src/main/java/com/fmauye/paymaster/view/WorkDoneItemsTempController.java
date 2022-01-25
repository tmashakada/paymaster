/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.dto.ItemDto;
import com.fmauye.paymaster.entity.Customer;
import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.entity.WorkDoneItemsTemp;
import com.fmauye.paymaster.service.ItemServiceImpl;
import com.fmauye.paymaster.service.WorkDoneItemsTempService;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    @Autowired
    private ItemServiceImpl itemServiceImpl;
    private String item;
    List<String> itemsstr;
    private List<Item> items;
  
     private List<ItemDto> itemDtos;
     
     private List<ItemDto> filteredItemList;
     private List<ItemDto> selectedItemList;
    private int qty;
    private String username;
    @PostConstruct
    public void init() {
        
    }

    public String getUsername() {
         FacesContext context = FacesContext.getCurrentInstance();
        username = context.getExternalContext().getSessionMap().get("user_name").toString();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public List<ItemDto> getFilteredItemList() {
        return filteredItemList;
    }

    public void setFilteredItemList(List<ItemDto> filteredItemList) {
        this.filteredItemList = filteredItemList;
    }

    public List<ItemDto> getSelectedItemList() {
        return selectedItemList;
    }

    public void setSelectedItemList(List<ItemDto> selectedItemList) {
        this.selectedItemList = selectedItemList;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    
    public List<Item> getItems() {
        items=itemServiceImpl.getAllItems();
        
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<String> getItemsstr() {
        List<String> str=new ArrayList<>();
        for(Item item:getItems()){
            String desc=item.getDescription();
           itemsstr.add(desc);
        }
        
        return itemsstr;
    }

    public void setItemsstr(List<String> itemsstr) {
        this.itemsstr = itemsstr;
    }

    public List<ItemDto> getItemDtos() {
        System.out.println("Get All Items username "+username);
       List<WorkDoneItemsTemp> tempList=  workDoneItemsTempService.getAll(username);
          System.out.println("Templist "+tempList.size());
          List<ItemDto> newLst=new ArrayList<>();
       int count=0;
       for(WorkDoneItemsTemp temp: tempList){
           count++;
           System.out.println("Get All Items desc "+temp.getDescription());
           ItemDto itemDto=new ItemDto();
           itemDto.setAmount(temp.getAmount().longValueExact());
           itemDto.setQty(temp.getQty());
           itemDto.setDescription(temp.getDescription());
           itemDto.setTotalamount(temp.getTotalamount().longValueExact());
            
           itemDto.setNumber(count);
            newLst.add(itemDto);
         }
          System.out.println("Numbers of Item "+  newLst.size());
          itemDtos= newLst;
        return itemDtos;
    }

    public void setItemDtos(List<ItemDto> itemDtos) {
        this.itemDtos = itemDtos;
    }
    
    public void  saveTemp(){
        System.out.println("  Subtmitted the items  Form Refe Number is "+item);
       
        try{
        Item itemm=itemServiceImpl.getItem(item);
        WorkDoneItemsTemp temp=new WorkDoneItemsTemp();
        temp.setAmount(itemm.getAmount());
        temp.setCreatedAt(LocalDateTime.now());
        temp.setDescription(itemm.getDescription());
        temp.setUpdatedAt(LocalDateTime.now());
       
        BigDecimal itemCost  = itemm.getAmount().multiply(BigDecimal.valueOf(qty));
        temp.setTotalamount(itemCost);
        temp.setQty(qty);
        temp.setUsername(username);
        workDoneItemsTempService.create(temp);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successful Added Item "+item));
        }catch(Exception ex){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",  ex.getMessage()+item));
    }
        
        }
     public void  submitWork(){
      WorkDone workDone= workDoneItemsTempService.saveWorkDone(username);
      
      System.out.println("Successful  Subtmitted the Form Refe Number is "+workDone.getId());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successful Subtmitted Work Ref "+workDone.getId()));
     }
     public String getTotalRevenue() {
		if (this.itemDtos == null) {
			return "0";
		}
             //new DecimalFormat("#0.##").format(bd)
             Long totalRevenue = itemDtos.stream().mapToLong(ItemDto::getTotalamount).sum();
		return new DecimalFormat("###,###.###").format(totalRevenue);
        
	}
     public void deleteCustomers() {
            /**
		for (Customer customer : selectedCustomerList) {
			this.customerService.deleteCustomer(customer);

			if (filteredCustomerList != null) {
				this.filteredCustomerList.remove(customer);
			}

			this.customers = customerService.getCustomers();
		}
                **/
	}
     
}
