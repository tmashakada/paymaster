/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.entity;

import com.fmauye.paymaster.enums.UserRole;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author "Tafadzwa"
 */
@Entity
public class Users implements Serializable {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name="created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false,name="first_name")
    private String firstName;
     @Column(nullable = false,name="last_name")
    private String lastName;
    private String email;
    private String password;
    private String ecnumber;
    private String title;
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    
    @Column(nullable = false,name="mobile_number")
    private String mobileNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name="user_role")
    private UserRole userRole;
    @Column(nullable = false,name="user_name")
    private String userName;
    private Boolean locked;
    private Boolean enabled;

    public Users() {
    }

    
    public Users(String firstName, String lastName, String email, String password, String ecnumber, Department department, UserRole userRole,String mobilenumber,String  username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ecnumber = ecnumber;
        this.department = department;
        this.userRole = userRole;
        this.mobileNumber=mobilenumber;
        this.userName= username;
        this.locked = false;
        this.enabled = false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobilenumber) {
        this.mobileNumber = mobilenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
