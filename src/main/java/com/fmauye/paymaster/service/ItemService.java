/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fmauye.paymaster.service;
import com.fmauye.paymaster.entity.Item;
import java.util.List;


/**
 *
 * @author F5437172
 */
public interface ItemService {
    List<Item> getAllItems();
    Item createItem(Item item);
    Item updateItem(Item item,Long id);
    Item getItem(Long id);
    Item getItem(String name);
}
