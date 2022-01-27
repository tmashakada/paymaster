/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

/**
 *
 * @author F5437172
 */
public class ValidateNumber {
    
    
   public static  boolean isValidMobile(String mobile ){
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
    
}
