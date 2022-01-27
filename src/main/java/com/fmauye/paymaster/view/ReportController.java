/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Item;
import com.fmauye.paymaster.entity.Users;
import com.fmauye.paymaster.entity.WorkDone;
import com.fmauye.paymaster.entity.WorkDoneItems;
import com.fmauye.paymaster.model.SmsRequest;
import com.fmauye.paymaster.service.ItemServiceImpl;
import com.fmauye.paymaster.service.SmsSenderServiceImpl;
import com.fmauye.paymaster.service.UsersService;
import com.fmauye.paymaster.service.WorkDoneItemsService;
import com.fmauye.paymaster.service.WorkDoneService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
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
     private WorkDone workDone;
     private WorkDone workDoneSelected;
     private List<WorkDone> userapprovedreport;
   
     private List<WorkDone> userpendingreport;
     
     private List<WorkDone> hodpendingreport;
     private List<WorkDone> hodpaidreport;
     private List<WorkDone> hodapprovedreport;
     private List<WorkDone> hodrejectedreport;
     
     private List<WorkDone> adminpaidreport;
     private List<WorkDone> adminapprovedreport;
     private List<WorkDone> adminrejectedreport;
     
     
     private List<WorkDone> reject_report;
     private List<WorkDone> paid_report;
     private List<Item> allItems_report;
     private List<WorkDoneItems> workDoneItemsList;
     @Autowired
     private  ItemServiceImpl itemServiceImpl;
     @Autowired
     private WorkDoneService  workDoneService;
     @Autowired
     WorkDoneItemsService  workDoneItemsService;
     @Autowired
     UsersService usersService;
     @Autowired
     SmsSenderServiceImpl  smsSenderServiceImpl;
     
     private String username;
     private Users users;
     private Users users2;
    @PostConstruct
    public void init() {
        
    }

    public WorkDone getWorkDoneSelected() {
        return workDoneSelected;
    }

    public void setWorkDoneSelected(WorkDone workDoneSelected) {
        this.workDoneSelected = workDoneSelected;
    }
    
    public String getUsername() {
          FacesContext context = FacesContext.getCurrentInstance();
        username = context.getExternalContext().getSessionMap().get("user_name").toString();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
public void preRenderView(ComponentSystemEvent event)  {
          FacesContext context = FacesContext.getCurrentInstance();
      String   usernames = context.getExternalContext().getSessionMap().get("user_name").toString();
      username=usernames;
          System.out.println("REOprt preRenderView User Name nnnnnnJTesttesttttttt"+ usernames);
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }
        readFromDatabase();
    }
     
    
     
      private void readFromDatabase() {
         
             //use _strID to read and set property
             System.out.println("User Name nnnnnnJJJjjjKKkkKKkKkK"+ username);
      }
     public Users getUsers() {
       Users user=   usersService.getUsersByUserName(username);
       users=user;
        return users;
     }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers2() {
          Users user=   usersService.getUsersByUserName(workDone.getSubmittedBy());
       users2=user;
        return users2;
    }

    public void setUsers2(Users users2) {
        this.users2 = users2;
    }

  

    public WorkDone getWorkDone() {
        
       // System.out.println("Sub Work Done +++++++++++++"+workDone.getSubmittedBy());
        return workDone;
    }

    public void setWorkDone(WorkDone workDone) {
        this.workDone = workDone;
    }

   
    
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

    public List<WorkDone> getUserapprovedreport() {
         System.out.println("Approved user name "+username);
         List<WorkDone> workdoneList= workDoneService.getAllByUserNameAndStatus(username, "APPROVED");
          userapprovedreport= workdoneList;
        return userapprovedreport;
    }

    public void setUserapprovedreport(List<WorkDone> userapprovedreport) {
        this.userapprovedreport = userapprovedreport;
    }

    public List<WorkDone> getUserpendingreport() {
        System.out.println("HHH Pending user name "+username);
       List<WorkDone> workdoneList= workDoneService.getAllByUserNameAndStatus(username, "PENDING");
        System.out.println("HHH Pending user name "+username);
       userpendingreport= workdoneList;
        return userpendingreport;
    }

    public List<WorkDone> getHodpendingreport() {
          System.out.println("Pending HOD name "+username );
           System.out.println("Pending HOD Department "+users.getDepartment().getDescription() );
        List<WorkDone> workdoneList= workDoneService.getAllByDepartmentAndStatus(users.getDepartment().getDescription(),"PENDING");
     
        hodpendingreport= workdoneList;
        
        return hodpendingreport;
    }

    public void setHodpendingreport(List<WorkDone> hodpendingreport) {
        
        this.hodpendingreport = hodpendingreport;
    }

    public List<WorkDone> getHodpaidreport() {
          System.out.println("PAID HOD name "+username);
          List<WorkDone> workdoneList= workDoneService.getAllByDepartmentAndStatus(users.getDepartment().getDescription(),"PAID");
          hodpaidreport= workdoneList;
        
        return hodpaidreport;
    }

    public void setHodpaidreport(List<WorkDone> hodpaidreport) {
        this.hodpaidreport = hodpaidreport;
    }

    public List<WorkDone> getHodapprovedreport() {
         List<WorkDone> workdoneList= workDoneService.getAllByDepartmentAndStatus(users.getDepartment().getDescription(),"APPROVED");
         hodapprovedreport= workdoneList;
        return hodapprovedreport;
    }

    public void setHodapprovedreport(List<WorkDone> hodapprovedreport) {
        this.hodapprovedreport = hodapprovedreport;
    }

    public List<WorkDone> getHodrejectedreport() {
          System.out.println("REJECTED HOD name "+username);
          List<WorkDone> workdoneList= workDoneService.getAllByDepartmentAndStatus(users.getDepartment().getDescription(),"REJECTED");
         hodrejectedreport= workdoneList;
        return hodrejectedreport;
    }

    public void setHodrejectedreport(List<WorkDone> hodrejectedreport) {
        this.hodrejectedreport = hodrejectedreport;
    }

    public List<WorkDone> getAdminpaidreport() {
         List<WorkDone> workdoneList= workDoneService.getAllByStatus("PAID");
         adminpaidreport=workdoneList;
        return adminpaidreport;
    }

    public void setAdminpaidreport(List<WorkDone> adminpaidreport) {
        this.adminpaidreport = adminpaidreport;
    }

    public List<WorkDone> getAdminapprovedreport() {
         List<WorkDone> workdoneList= workDoneService.getAllByStatus("APPROVED");
         adminapprovedreport=workdoneList;
       
        return adminapprovedreport;
    }

    public List<WorkDone> getAdminrejectedreport() {
         List<WorkDone> workdoneList= workDoneService.getAllByStatus("REJECTED");
        adminrejectedreport=workdoneList;
        return adminrejectedreport;
    }

    public void setAdminrejectedreport(List<WorkDone> adminrejectedreport) {
        this.adminrejectedreport = adminrejectedreport;
    }

    public void setAdminapprovedreport(List<WorkDone> adminapprovedreport) {
        this.adminapprovedreport = adminapprovedreport;
    }
    
    
    
     public List<WorkDoneItems> getWorkDoneItemsList() {
       // for(<WorkDone workDone:userpendingreport
       Long id= workDone.getId();
       System.out.println("Test  "+id);
      
      
       Long workdoneid=0L;
      for(WorkDone workDone: userpendingreport){
          workdoneid=workDone.getId();
      }
        List<WorkDoneItems> wlist=workDoneItemsService.getWorkDoneItemsByWorkDoneId(workdoneid);
        workDoneItemsList=wlist;
        return workDoneItemsList;
    }

    public void setWorkDoneItemsList(List<WorkDoneItems> workDoneItemsList) {
        this.workDoneItemsList = workDoneItemsList;
    }
    
    public void setUserpendingreport(List<WorkDone> userpendingreport) {
        this.userpendingreport = userpendingreport;
    }

   


    public List<WorkDone> getReject_report() {
         List<WorkDone> workdoneList= workDoneService.getAllByUserNameAndStatus(username, "REJECTED");
       reject_report= workdoneList;
        return reject_report;
    }

    public void setReject_report(List<WorkDone> reject_report) {
        this.reject_report = reject_report;
    }

    public List<WorkDone> getPaid_report() {
         List<WorkDone> workdoneList= workDoneService.getAllByUserNameAndStatus(username, "PAID");
       paid_report= workdoneList;
        return paid_report;
    }

    public void setPaid_report(List<WorkDone> paid_report) {
        this.paid_report = paid_report;
    }

    
    public List<Item> getAllItems_report() {
          allItems_report=  itemServiceImpl.getAllItems();
        return allItems_report;
    }

    public void setAllItems_report(List<Item> allItems_report) {
        this.allItems_report = allItems_report;
    }
 
     public  void approveWorkDone(Long id, String subtmittedby){
        

        if (workDoneService.update(id, username,"APPROVED")) {
            
            Users user=   usersService.getUsersByUserName(subtmittedby);
            SmsRequest smsRequest=new SmsRequest();
            smsRequest.setMessage("Your Submitted Work Referrence Number "+id+ " Successfully Approved " );
            smsRequest.setPhoneNumber(user.getMobileNumber());
            smsSenderServiceImpl.sendSms(smsRequest);
            
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successful Added Item "+item));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully Approved!!."));

            

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to Approved!!."));
        }
    }

     public  void payWorkDone(Long id, String subtmittedby){
        

        if (workDoneService.update(id, username,"PAID")) {
            
            Users user=   usersService.getUsersByUserName(subtmittedby);
            SmsRequest smsRequest=new SmsRequest();
            smsRequest.setMessage("Your Submitted Work Referrence Number "+id+ " Successfully Approved By HR for PayMents " );
            smsRequest.setPhoneNumber(user.getMobileNumber());
            smsSenderServiceImpl.sendSms(smsRequest);
            
          //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successful Added Item "+item));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully Approved!!."));

            

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to Approved!!."));
        }
    }
      public void onRowSelect(SelectEvent<WorkDone> event) {
        FacesMessage msg = new FacesMessage("WorkDone Selected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
