/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.SmsSent;
import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.repository.SmsSentRepository;
import com.fmauye.paymaster.service.SmsSenderServiceImpl;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author F5437172
 */
@Named
@ViewScoped
public class SmsSentReport {
   
    private List<SmsSent> smsSentReportAll;
     @Autowired
     private SmsSenderServiceImpl   smsSenderServiceImpl;
    public SmsSentReport() {
    }

    public List<SmsSent> getSmsSentReportAll() {
        smsSentReportAll= smsSenderServiceImpl.getAllSmsSent();
        
        return smsSentReportAll;
    }

    public void setSmsSentReportAll(List<SmsSent> smsSentReportAll) {
        this.smsSentReportAll = smsSentReportAll;
    }

   

   
    
    
}
