/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author "Tafadzwa"
 */
@Service
public class GenerateOpt {
     public  String generateToken(){
         Random random = new Random();
         int otp = 100000 + random.nextInt(900000);
         String optstr=String.valueOf(otp);
        return  optstr;
    }
    
    
}
