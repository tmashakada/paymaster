/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.service.ItemServiceImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author F5437172
 */

@FacesConverter("itemConverter")
public class ItemConverter implements Converter{
    @Autowired
    private ItemServiceImpl itemServiceImpl;
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String  value) {
      // This method is called when HTTP request parameter is to be converted to item value.
    // You need to convert the student ID back to Student.
    Long id = Long.valueOf(value);
    Item item = itemServiceImpl.getItem(id);
    return item;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object  value) {
       Item item = (Item) value;
    Long id = item.getId();
    return String.valueOf(id);
    }
    
}
