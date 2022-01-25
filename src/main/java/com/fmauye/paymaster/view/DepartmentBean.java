/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.service.DepartmentServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author "Tafadzwa"
 */
@Named
@SessionScoped
public class DepartmentBean implements Serializable{
    
     private List<Department> departments;
     
     private List<Department> departmentsList;
     private String departdescription;
     @Autowired
     DepartmentServiceImpl departmentServiceImpl;
    @PostConstruct
    public void init() {
        departments = new ArrayList<>();
        departments= departmentServiceImpl.getAllDepartments();
    }

    public List<Department> getDepartments() {
        
        
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getDepartdescription() {
        return departdescription;
    }

    public void setDepartdescription(String departdescription) {
        this.departdescription = departdescription;
    }

    public List<Department> getDepartmentsList() {
        
      List<Department>    departmentList= departmentServiceImpl.getAllDepartments();
      departmentsList=departmentList;
        return departmentsList;
    }

    public void setDepartmentsList(List<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    
    public void createNewDepartment(){
        
     Department department= departmentServiceImpl.createDepartment(departdescription);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Created Successful New Department "+department.getDescription()));
     
    }
    
}
