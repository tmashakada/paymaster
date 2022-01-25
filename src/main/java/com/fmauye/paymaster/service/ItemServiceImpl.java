/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.exception.ResourceNotFoundException;

import com.fmauye.paymaster.repository.ItemRepository;
import java.math.BigDecimal;
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
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    
    
    @Override
    public List<Item> getAllItems() {
         return  itemRepository.findAll();
    }

    @Override
    public Item createItem(Item item)  throws ResourceNotFoundException {
        Optional<Item> itemOpt=itemRepository.findItemByDescriptionIgnoreCase(item.getDescription());
       if(itemOpt.isPresent())
          throw new ResourceNotFoundException("Item Already Created  "+item.getDescription()) ;
       
       item.setCreatedAt(LocalDateTime.now());
       item.setUpdatedAt(LocalDateTime.now());
       item.setIsDeleted(false);
       return this.itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item ,Long id) {
        Item existingItem=this.itemRepository.findById(id)
     		   .orElseThrow(() -> new ResourceNotFoundException("Item Not Found with "+id));
    	
    	existingItem.setUpdatedAt(LocalDateTime.now());
    	existingItem.setDescription( item.getDescription());
        existingItem.setAmount(item.getAmount());
    	
    	return this.itemRepository.save(existingItem);
    }

    @Override
    public Item getItem(Long id) {
      return this.itemRepository.getById(id);
    }

    @Override
    public Item getItem(String name) {
        Optional<Item> itemOpt=itemRepository.findItemByDescriptionIgnoreCase(name);
        return itemOpt.get();
    }
    
}
