/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;


import com.fmauye.paymaster.repository.UsersRepository;
import com.fmauye.paymaster.entity.ConfirmationToken;
import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.exception.UsernameNotFoundException;
import com.fmauye.paymaster.model.SmsRequest;
import com.twilio.exception.ApiException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author "Tafadzwa"
 */
@Service
public class UsersService {
     private static final Logger LOGGER = LoggerFactory.getLogger(UsersService.class);
    @Autowired
    private UsersRepository usersRepository;
    @Autowired 
    private EncrytPasswordServiceImpl encrytPasswordServiceImpl;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    
    @Autowired
    SmsSenderService  smsSenderService;
    
    @Autowired
    GenerateOpt  generateOpt;

    
    
    public   Users verifyLogin(String username, String password) throws UsernameNotFoundException {
        
       Optional<Users> usersopt = usersRepository.findByUserNameIgnoreCase(username);
          LOGGER.info("Veify User {}", usersopt.get().getDepartment());
       if (!usersopt.isPresent()) {
            throw new UsernameNotFoundException ("The UserName you entered is Not Found");
        }

        if (usersopt.get().getEnabled() ==false) {
           throw new UsernameNotFoundException ("Your Account is not confirmed");
        }
        if (usersopt.get().getLocked() ==true) {
           throw new UsernameNotFoundException ("Your Account is Locked Plaese Contact The System Admin");
        }
             LOGGER.info("Veify User {}", "Here2");
        String encodedPassword = encrytPasswordServiceImpl.hashPassword(password);
        System.out.println("HashedPass "+encodedPassword );
        System.out.println("DbPass "+usersopt.get().getPassword() );
        if(!encodedPassword.equals(usersopt.get().getPassword())){
             throw new UsernameNotFoundException ("The Password that you've entered is incorrect"); 
        }
        
        Users users=usersopt.get();
        return  users;
        
        
    }
  
    
    public Users getUserByUserName(String username) throws UsernameNotFoundException{
           Optional<Users> usersopt = usersRepository.findByUserNameIgnoreCase(username);

       if (!usersopt.isPresent()) {
            throw new UsernameNotFoundException ("The User Name you entered is Not Found");
        }
        return usersopt.get();
       
       
    }
     
    public String resendOpt(String username)throws UsernameNotFoundException {
         Optional<Users> usersopt = usersRepository.findByUserNameIgnoreCase(username);

       if (!usersopt.isPresent()) {
            throw new UsernameNotFoundException ("The UserName is Not Found "+" "+username);
        }
        
        
         Users user= usersopt.get();
         String  opt=  generateOpt.generateToken();
         saveConfirmationToken(user, opt);
         String msg =  opt+" "+"is Your verification Code from PayMaster";
         String result=  sentOpt(msg, user.getMobileNumber());
         return result;

        
    }
    private String sentOpt(String msg,String mobilenumber){
         SmsRequest  smsRequest=new SmsRequest();
            smsRequest.setMessage(msg);
            smsRequest.setPhoneNumber(mobilenumber);
            String success;
            try{
                success=  smsSenderService.sendSms( smsRequest);
                  return  success;
            }catch(ApiException e){
                success=e.getMessage();
                return success;
            }
    }
    
    public String signUpUser(Users user) {
       // boolean userExists = usersRepository.findByEmail(user.getEmail()).isPresent();
       System.out.println("Sing up");
      Optional<Users> usersopt= usersRepository.findByEmail(user.getEmail());
       System.out.println("Sing up2");
        if (usersopt.isPresent()) {

            Users appUserPrevious = usersopt.get();
            Boolean isEnabled = appUserPrevious.getEnabled();

            if (!isEnabled) {
                 String optstr=generateOpt.generateToken();

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
         
       String optstr=generateOpt.generateToken();
        //Getting the confirmation token and then saving it
        saveConfirmationToken(user, optstr);


        //Returning token
        return optstr;
    }
   
//ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, LocalDateTime confirmedAt, Users users) 
    public void saveConfirmationToken(Users appUser, String token) {
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
    }

    public int enableAppUser(String email) {
        return usersRepository.enableAppUser(email);

    }
   public void expireConfirmationToken(Users appUser) throws UsernameNotFoundException{
  
       //  String token=confirmationTokenService.getTokenByUser(appUser);
       String  token="No Token";
         if(token.equalsIgnoreCase("No Token")){
             
         }else{
               confirmationTokenService.setConfirmedAt(token);
         }
       
    }
}
