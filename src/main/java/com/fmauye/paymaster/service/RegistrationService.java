/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.ConfirmationToken;
import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.enums.UserRole;
import com.fmauye.paymaster.model.RegistrationRequest;
import com.fmauye.paymaster.model.SmsRequest;
import com.fmauye.paymaster.repository.DepartmentRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author "Tafadzwa"
 */

@Service
public class RegistrationService {
    @Autowired
    private  UsersService usersService;
    @Autowired
    DepartmentRepository departmentRepository;
     @Autowired
    private  EmailValidator emailValidator;
          
    @Autowired
    private  ConfirmationTokenService confirmTokenService;
    @Autowired
    private  SmsSenderService smsSender;
    
     public String register2(RegistrationRequest request) {
         System.out.println("ghhhhhhh");
        return "Success"; 
     }
     
     public String register(RegistrationRequest request) {
         System.out.println("Register1 ");
    
        System.out.println("Register2 ");
       
            
            
            System.out.println("Register3 ");
            Optional<Department> departmentopt=departmentRepository.findById(request.getDepartmentId());
              System.out.println("Register31 ");
            Department department=departmentopt.get();
             Users users=new Users();
             users.setCreatedAt(LocalDateTime.now());
             users.setDepartment(department);
             users.setEcnumber( request.getEcnumber());
             users.setEmail(request.getEmail());
             users.setEnabled(false);
             users.setLocked(false);
             users.setFirstName(request.getFirstName());
             users.setLastName(request.getLastName());
             users.setMobileNumber(request.getMobilenumber());
             users.setPassword(request.getPassword());
             users.setUserName(request.getUsername());
             users.setUserRole(UserRole.USER);
               System.out.println("Register4 ");
            
            String optForNewUser = usersService.signUpUser(users);
            
              System.out.println("Register5 ");
            String msg =  optForNewUser+" "+"is Your verification Code PayMaster";
            SmsRequest  smsRequest=new SmsRequest();
            smsRequest.setMessage(msg);
            smsRequest.setPhoneNumber(request.getMobilenumber());
            smsSender.sendSms( smsRequest);
            
            return optForNewUser;
        
    }


    @Transactional
    public String confirmToken(String token) {
        Optional<ConfirmationToken> confirmToken = confirmTokenService.getToken(token);

        if (!confirmToken.isPresent()) {
            throw new IllegalStateException("OPT not found!");
        }

        if (confirmToken.get().getConfirmedAt() != null) {
            throw new IllegalStateException("Number is already confirmed");
        }

        LocalDateTime expiresAt = confirmToken.get().getExpiresAt();

        if (expiresAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("OTP is already expired!");
        }

        confirmTokenService.setConfirmedAt(token);
        usersService.enableAppUser(confirmToken.get().getUsers().getEmail());

        //Returning confirmation message if the token matches
        return "Your Account is confirmed. Thank you for using our service!";
    }

}
