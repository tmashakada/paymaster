/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.view;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author "Tafadzwa"
 */
@Named
@SessionScoped
public class LogoutController  implements Serializable{
    public LogoutController() {
    }
    
    
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Logout");
        return "/login?faces-redirect=true";
    }
}
