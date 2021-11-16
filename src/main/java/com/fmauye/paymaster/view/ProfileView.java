/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.exception.UsernameNotFoundException;
import com.fmauye.paymaster.service.UsersService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author "Tafadzwa"
 */
@Named
@SessionScoped
public class ProfileView implements Serializable{
     private String title;
     private String username;
     private String firstname;
     private String surname;
     private String mobilenumber;
     private String department;
     private String userrole;
     @Autowired
     private UsersService usersService;
    public ProfileView() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
    
    
    public void preRenderView(ComponentSystemEvent event)  {
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }
        readFromDatabase();
    }
private void readFromDatabase() {
         try {
             //use _strID to read and set property
             System.out.println("User Name"+ username);
             Users user=usersService.getUserByUserName(username);
               System.out.println("User Name"+ user.getUserName());
             username=user.getUserName();
             title=user.getTitle();
             firstname=user.getFirstName();
             surname=user.getLastName();
             firstname=user.getFirstName();
             mobilenumber=user.getMobileNumber();
             department=user.getDepartment().getDescription();
             userrole=user.getUserRole().name();
         } catch (UsernameNotFoundException ex) {
             Logger.getLogger(ProfileView.class.getName()).log(Level.SEVERE, null, ex);
         }catch(NullPointerException e){
              System.out.println("User Name");
               Logger.getLogger(ProfileView.class.getName()).log(Level.SEVERE, null, e);
         }

}
}
