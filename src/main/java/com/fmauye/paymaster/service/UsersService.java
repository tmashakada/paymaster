/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;


import com.fmauye.paymaster.repository.UsersRepository;
import com.fmauye.paymaster.entity.ConfirmationToken;
import com.fmauye.paymaster.entity.Users;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author "Tafadzwa"
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired 
    private EncrytPasswordServiceImpl encrytPasswordServiceImpl;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

  
      public String signUpUser(Users user) {
       // boolean userExists = usersRepository.findByEmail(user.getEmail()).isPresent();
       System.out.println("Sing up");
      Optional<Users> usersopt= usersRepository.findByEmail(user.getEmail());
       System.out.println("Sing up2");
        if (usersopt.isPresent()) {

            Users appUserPrevious = usersopt.get();
            Boolean isEnabled = appUserPrevious.getEnabled();

            if (!isEnabled) {
                 Random random = new Random();
                 int otp = 100000 + random.nextInt(900000);
                String optstr=String.valueOf(otp);

                //A method to save user and token in this class
                saveConfirmationToken(appUserPrevious, optstr);

                return optstr;

            }
            throw new IllegalStateException(String.format("User with email %s already exists!", user.getEmail()));
        }

        
        String encodedPassword = encrytPasswordServiceImpl.hashPassword(user.getPassword());
        user.setPassword(encodedPassword);

        //Saving the user after encoding the password
        usersRepository.save(user);

        //Creating a token from UUID
        //String token = UUID.randomUUID().toString();
          Random random = new Random();
         int otp = 100000 + random.nextInt(900000);
         String optstr=String.valueOf(otp);

        //Getting the confirmation token and then saving it
        saveConfirmationToken(user, optstr);


        //Returning token
        return optstr;
    }
    
//ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, LocalDateTime confirmedAt, Users users) 
    private void saveConfirmationToken(Users appUser, String token) {
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
    }

    public int enableAppUser(String email) {
        return usersRepository.enableAppUser(email);

    }
}