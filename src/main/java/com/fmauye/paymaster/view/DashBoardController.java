/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.WorkDone;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author F5437172
 */
@Named
@ViewScoped
public class DashBoardController {
        
        List<WorkDone> pendinguserworkDoneList;
        List<WorkDone> paiduserworkDoneList;
        List<WorkDone> approveduserworkDoneList;
        List<WorkDone> rejecteduserworkDoneList;
        private String username;
        private int pending;
        private int paid;
        private int approved;
        private int rejected;
        @PostConstruct
	public void init() {
            
        }

    public int getPending() {
        int bb=3;
        pending=bb;
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<WorkDone> getPendinguserworkDoneList() {
        
        return pendinguserworkDoneList;
    }

    public void setPendinguserworkDoneList(List<WorkDone> pendinguserworkDoneList) {
        this.pendinguserworkDoneList = pendinguserworkDoneList;
    }

    public List<WorkDone> getPaiduserworkDoneList() {
        return paiduserworkDoneList;
    }

    public void setPaiduserworkDoneList(List<WorkDone> paiduserworkDoneList) {
        this.paiduserworkDoneList = paiduserworkDoneList;
    }

    public List<WorkDone> getApproveduserworkDoneList() {
        return approveduserworkDoneList;
    }

    public void setApproveduserworkDoneList(List<WorkDone> approveduserworkDoneList) {
        this.approveduserworkDoneList = approveduserworkDoneList;
    }

    public List<WorkDone> getRejecteduserworkDoneList() {
        return rejecteduserworkDoneList;
    }

    public void setRejecteduserworkDoneList(List<WorkDone> rejecteduserworkDoneList) {
        this.rejecteduserworkDoneList = rejecteduserworkDoneList;
    }
        
        
}


