/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.model;

import com.fmauye.paymaster.entity.Department;

/**
 *
 * @author "Tafadzwa"
 */
public class RegistrationRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String ecnumber;
    private  Long departmentId;
    private   String mobilenumber;
     private   String username;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String firstName, String lastName, String email, String password, String ecnumber, Long departmentId,String mobilenumber,String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ecnumber = ecnumber;
        this.departmentId = departmentId;
        this.mobilenumber=mobilenumber;
        this.username=username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

    
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getEcnumber() {
        return ecnumber;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    
    
}
