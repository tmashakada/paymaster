/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.model.SmsRequest;
import com.twilio.exception.ApiException;

/**
 *
 * @author "Tafadzwa"
 */
public interface SmsSenderService {
  String sendSms(SmsRequest smsRequest)throws ApiException ;
}
