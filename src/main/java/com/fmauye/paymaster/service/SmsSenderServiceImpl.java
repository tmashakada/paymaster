/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.config.TwilioConfiguration;
import com.fmauye.paymaster.model.SmsRequest;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author "Tafadzwa"
 */
@Service
public class SmsSenderServiceImpl implements SmsSenderService{
      @Autowired
     private  TwilioConfiguration twilioConfiguration;
     private static final Logger LOGGER = LoggerFactory.getLogger(SmsSenderServiceImpl.class);
  
   


    @Override
    public String sendSms(SmsRequest smsRequest) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
          return "Success";
    }
    
    
}
