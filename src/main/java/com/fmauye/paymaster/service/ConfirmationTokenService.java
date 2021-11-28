/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.repository.ConfirmationTokenRepository;
import com.fmauye.paymaster.entity.ConfirmationToken;
import com.fmauye.paymaster.entity.Users;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author "Tafadzwa"
 */
@Service
public class ConfirmationTokenService {
     @Autowired
     private ConfirmationTokenRepository confirmationTokenRepository;
     
      public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
     }
     public void expireConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
     }
     public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
     }
     public String  getTokenByUser(Users  user) {
         String  token;
         Optional<ConfirmationToken> confirmationOpt= confirmationTokenRepository.findByUsers(user);
            if(confirmationOpt.isPresent()){
               token=confirmationOpt.get().getToken();
           }else{
               token="No Token";
           }
        return  token;
        
    }
    
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
    
}
