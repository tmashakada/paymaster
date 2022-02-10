/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import org.springframework.stereotype.Service;


/**
 *
 * @author "Tafadzwa"
 */


@Service
public class EmailValidator   {
    private final String EMAIL_PATTERN = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

 
    public boolean isEmailValid(String email) {
          boolean isValidEmail = email.matches(EMAIL_PATTERN);
            if (isValidEmail) {
                return true;
            }else{
               //throw new IllegalStateException(String.format("Email %s, not valid", email)); 
                 return false;
            }
      
         
        
        
    }
    public   boolean isValidMobile(String mobile ){
       boolean isMobileValid=false;
     
       boolean isNumeric = mobile.chars().allMatch( Character::isDigit );
       if(isNumeric){
           
          if( mobile.startsWith("263")|| mobile.startsWith("27")){
              
             if( mobile.length()==11|| mobile.length()==12){
                 isMobileValid=true;
             }
          }
           
           
       }
       return isMobileValid;
   }
    
    public String  validaNumber(String number){
         if( number.substring(0, 1).equalsIgnoreCase("0")  ){
          number = number.substring(1);
          }
        long totalCharacters =number.chars().filter(ch -> ch != ' ').count();
        if(totalCharacters==9L){
         return number;
       }else{
             throw new IllegalStateException(String.format("Mobile Number %s, Not valid", number));
          
       }
       
    }
    
}
