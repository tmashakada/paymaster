/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.config;

/**
 *
 * @author "Tafadzwa"
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
        private final static Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);
     final String secretKey = "kukue";
     @Autowired
     TwilioAccountEncrypt twilioAccountEncrypt;
    
    
    private String accountSid;
    private String authToken;
    private String trialNumber;

    public TwilioConfiguration() {

    }

    public String getAccountSid() {
          LOGGER.info("Twilio initialized start ... with account sid {} ",  accountSid);
           String accountSidEn= twilioAccountEncrypt.decrypt(accountSid, secretKey);
          LOGGER.info("Twilio initialized start ... with account sid {} ",  accountSidEn);
           return  accountSidEn;
        
        //return   twilioAccountEncrypt.decrypt(accountSid, secretKey);
        
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
       // return twilioAccountEncrypt.decrypt(authToken, secretKey);
       LOGGER.info("Twilio initialized start ... with account auth {} ", authToken);
       String authTokenEn= twilioAccountEncrypt.decrypt(authToken, secretKey);
        LOGGER.info("Twilio initialized start ... with account auth {} ", authTokenEn);
        return authTokenEn;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}
