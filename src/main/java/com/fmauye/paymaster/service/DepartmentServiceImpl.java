/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.exception.ResourceNotFoundException;
import com.fmauye.paymaster.repository.DepartmentRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author "Tafadzwa"
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
         System.out.println("kkkkkkkkkkk");
         List<Department> nn=  departmentRepository.findAll();
        System.out.println(" fffffffffffff"+  nn.size());
       return  departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(String depart)throws ResourceNotFoundException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Optional<Department> departmentOpt=departmentRepository.findDepartmentByDescriptionIgnoreCase(depart);
       if(departmentOpt.isPresent())
          throw new ResourceNotFoundException("Department Already Created  "+depart) ;
       Department department=new Department();
       department.setDescription(depart);
       department.setCreatedAt(LocalDateTime.now());
      
       return this. departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        
        return this. departmentRepository.findById(id)
    		   .orElseThrow(() -> new ResourceNotFoundException("Department Not Found with "+id));
    }

    @Override
    public Department getDepartmentByName(String name) {
      return this.departmentRepository.findDepartmentByDescriptionIgnoreCase(name)
              .orElseThrow(() -> new ResourceNotFoundException("Department Not Found with Name "+name));
    		   
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
       Department existingDepartment=this.departmentRepository.findById(id)
     		   .orElseThrow(() -> new ResourceNotFoundException("Department Not Found with "+id));
    	
    	existingDepartment.setCreatedAt(LocalDateTime.now());
    	existingDepartment.setDescription(department.getDescription());
    
    	
    	return this.departmentRepository.save(existingDepartment);
    }
    
}
