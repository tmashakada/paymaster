/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.exception;

/**
 *
 * @author "Tafadzwa"
 */

public class UsernameNotFoundException extends Exception{

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

   
    public UsernameNotFoundException(Throwable message) {
        super(message);
    }

    
}
