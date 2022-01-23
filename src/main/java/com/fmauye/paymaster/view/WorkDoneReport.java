/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import java.util.Date;

/**
 *
 * @author F5437172
 */
public class WorkDoneReport {
    private Date fromDate;
    private Date toDate;
    
    private int transID;
    private Date createdat;
    private Date updatedat;
    
    private String hodstatus;
    private String hrstatus;
    private String hrapprovedby;
    private String hodapprovedby;
    private String department;
    private String submittedby;
   
    private double totalAmount;

    public WorkDoneReport() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getHodstatus() {
        return hodstatus;
    }

    public void setHodstatus(String hodstatus) {
        this.hodstatus = hodstatus;
    }

    public String getHrstatus() {
        return hrstatus;
    }

    public void setHrstatus(String hrstatus) {
        this.hrstatus = hrstatus;
    }

    public String getHrapprovedby() {
        return hrapprovedby;
    }

    public void setHrapprovedby(String hrapprovedby) {
        this.hrapprovedby = hrapprovedby;
    }

    public String getHodapprovedby() {
        return hodapprovedby;
    }

    public void setHodapprovedby(String hodapprovedby) {
        this.hodapprovedby = hodapprovedby;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubmittedby() {
        return submittedby;
    }

    public void setSubmittedby(String submittedby) {
        this.submittedby = submittedby;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
}
