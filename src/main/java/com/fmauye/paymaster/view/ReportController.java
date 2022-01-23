/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.service.ItemServiceImpl;
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
public class ReportController {
     private SmsSentReport smsSentReport;
     private WorkDoneReport workDoneReport;
     private List<WorkDoneReport> approved_report;
     private List<WorkDoneReport> pending_report;
     private List<WorkDoneReport> reject_report;
     private List<WorkDoneReport> paid_report;
     private List<Item> allItems_report;
     @Autowired
     private  ItemServiceImpl itemServiceImpl;
     
    public WorkDoneReport getWorkDoneReport() {
        return workDoneReport;
    }

    public void setWorkDoneReport(WorkDoneReport workDoneReport) {
        this.workDoneReport = workDoneReport;
    }

    public SmsSentReport getSmsSentReport() {
        return smsSentReport;
    }

    public void setSmsSentReport(SmsSentReport smsSentReport) {
        this.smsSentReport = smsSentReport;
    }

    public List<WorkDoneReport> getApproved_report() {
        return approved_report;
    }

    public void setApproved_report(List<WorkDoneReport> approved_report) {
        this.approved_report = approved_report;
    }

    public List<WorkDoneReport> getPending_report() {
        return pending_report;
    }

    public void setPending_report(List<WorkDoneReport> pending_report) {
        this.pending_report = pending_report;
    }

    public List<WorkDoneReport> getReject_report() {
        return reject_report;
    }

    public void setReject_report(List<WorkDoneReport> reject_report) {
        this.reject_report = reject_report;
    }

    public List<WorkDoneReport> getPaid_report() {
        return paid_report;
    }

    public void setPaid_report(List<WorkDoneReport> paid_report) {
        this.paid_report = paid_report;
    }

    
    public List<Item> getAllItems_report() {
          allItems_report=  itemServiceImpl.getAllItems();
        return allItems_report;
    }

    public void setAllItems_report(List<Item> allItems_report) {
        this.allItems_report = allItems_report;
    }
 
     
}
