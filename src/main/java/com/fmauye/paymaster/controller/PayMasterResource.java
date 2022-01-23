/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.controller;

import com.fmauye.paymaster.service.DepartmentServiceImpl;
import com.fmauye.paymaster.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fmauye.paymaster.dto.UserDto;
import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.service.ItemServiceImpl;
/**
 *
 * @author F5437172
 */
@RestController
@RequestMapping("/api")
public class PayMasterResource {
    //createDepartments
    //getalldepartments
    //getdepartmentbyid
    
   
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @Autowired
    private UsersService usersService;
    
    @Autowired
    private ItemServiceImpl itemServiceImpl ;
    
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
       
        return departmentServiceImpl.getAllDepartments();
    }
    @PostMapping("/departments")
    public Department createNewDepartment(@RequestBody Department department){
        
        return departmentServiceImpl.createDepartment(department);
    }
    
    
    @GetMapping("/users")
    List<Users> getAllUsers(){
        
          return usersService.getALlUsers();
    }
    @PutMapping("/users")
    public Users updateUser(@RequestBody UserDto userdto){
        
         return usersService.updateUsers(userdto);
    }
    @PostMapping("/items")
    public Item createNewItem(@RequestBody Item item){
        
        return itemServiceImpl.createItem(item);
    }
    @GetMapping("/items")
    List<Item> getAllItems(){
        
          return itemServiceImpl.getAllItems();
    }
  
}
