/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.enums.UserRole;
import com.fmauye.paymaster.exception.UsernameNotFoundException;
import com.fmauye.paymaster.service.RegistrationService;
import com.fmauye.paymaster.service.UsersService;
import java.io.Serializable;
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
public class LoginBean implements Serializable{
     private  String username;
     private  String password;
     @Autowired
     private UsersService usersService;

     
    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String checkLogin() throws UsernameNotFoundException{
        System.out.println("Login");
         FacesContext context = FacesContext.getCurrentInstance();
      try { 
              System.out.println("Login isnnn");
             Users  user =usersService.verifyLogin(username, password);
             
             String userRole=user.getUserRole().toString();
        
        if(userRole.equalsIgnoreCase(UserRole.ADMIN.name())){
             context.getExternalContext().getSessionMap().put("user_name", username);
             
             return "/admin/index?faces-redirect=true";
        }else if(userRole.equalsIgnoreCase(UserRole.HOD.name())){
               context.getExternalContext().getSessionMap().put("user_name", username);
               
               return "/hod/index?faces-redirect=true";
        }else{
             context.getExternalContext().getSessionMap().put("user_name", username);
              return "/user/index?faces-redirect=true";
        }
        
        
      }catch(UsernameNotFoundException e){
          
         if(e.getMessage().equalsIgnoreCase("Your Account is not confirmed")) {
             context.getExternalContext().getSessionMap().put("user_name", username);
               return "/accountnotconfirment?faces-redirect=true";
         }else{
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage()));
         }
      } 
         return null;
    }
     //get user name in session and put it userName 
    public String getUseName() {
        FacesContext context = FacesContext.getCurrentInstance();
        username = context.getExternalContext().getSessionMap().get("user_name").toString();
        return username;
    }

   
    
}
