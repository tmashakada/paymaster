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
     private String department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
