/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Department;
import com.fmauye.paymaster.exception.UsernameNotFoundException;
import com.fmauye.paymaster.service.RegistrationService;
import com.fmauye.paymaster.model.RegistrationRequest;
import com.fmauye.paymaster.service.DepartmentServiceImpl;
import com.fmauye.paymaster.service.EmailValidator;
import com.fmauye.paymaster.service.UsersService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author "Tafadzwa"
 */
@Named
@ViewScoped
public class Registration implements Serializable{
    private RegistrationRequest request;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String ecnumber;

   // private  Department department = new  Department();
   
    private  String mobilenumber;
    private  String username;
    
 
     private String opt;
     private Department selectedDepartment;
     private List<Department> availableDepartments;
    private  String confirmpassword;
    private String selectedTitle;
    
     private Long departmentid;
    @Autowired
    private RegistrationService registrationService;
    
     @Autowired
     DepartmentServiceImpl departmentServiceImpl;
     @Autowired
     EmailValidator  emailValidator;
     @Autowired
     UsersService usersService;
     
    @PostConstruct
    public void init() {
         availableDepartments = new ArrayList<>();
         availableDepartments= departmentServiceImpl.getAllDepartments();
        for(Department department:availableDepartments){
            System.out.println("Department "+department.getDescription());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEcnumber() {
        return ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

   
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    
    
    public RegistrationRequest getRequest() {
        return request;
    }

    public void setRequest(RegistrationRequest request) {
        this.request = request;
    }
    
    public String register( RegistrationRequest request) {
        return registrationService.register(request);
        //return "registered";
    }

    public String getSelectedTitle() {
        return selectedTitle;
    }

    public void setSelectedTitle(String selectedTitle) {
        this.selectedTitle = selectedTitle;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public Department getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(Department selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public List<Department> getAvailableDepartments() {
        return availableDepartments;
    }

    public void setAvailableDepartments(List<Department> availableDepartments) {
        this.availableDepartments = availableDepartments;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

   

    public DepartmentServiceImpl getDepartmentServiceImpl() {
        return departmentServiceImpl;
    }

    public void setDepartmentServiceImpl(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    
    public String resent() {
        
       
        return null;
       
    }
    
    
    public String   resend() {
        try{
             FacesContext context = FacesContext.getCurrentInstance();
              System.out.println("nnnnn");
            String  useNamestr = context.getExternalContext().getSessionMap().get("user_name").toString();
             System.out.println("mmmmm");
            if (useNamestr!=null){
            System.out.println("User Name "+useNamestr);
            
            String response=   usersService.resendOpt(useNamestr);
            System.out.println(response);
            if(response.equalsIgnoreCase("Success")){
                 addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Opt Number successful Sent To Your Mobile");
            }else{
                 addMessage(FacesMessage.SEVERITY_ERROR, "ERROR Message", response);
            }
            }else{
               addMessage(FacesMessage.SEVERITY_ERROR, "ERROR Message", "UserName Is Null");
            }  
          
           // return "/resend?faces-redirect=true";
          }catch(UsernameNotFoundException ex){
                  System.out.println(ex.getMessage());
           FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage()));
          }catch(IllegalStateException ex){
               FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage()));
          }catch(NullPointerException ex){
               System.out.println("Error ");
                addMessage(FacesMessage.SEVERITY_ERROR, "ERROR Message", "UserName Is Null");
          }
        return null;
    }
     public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
  public String verify() {
       try{
          
           
         String response=   registrationService.confirmToken(opt);
         System.out.println(response);
         return "/singupsuccess?faces-redirect=true";
        }catch(IllegalStateException ex){
             System.out.println(ex.getMessage());
          FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage()));
         }
       
       
       
        return null;
       
  }
     public String  save() {
         try{
         RegistrationRequest request =new  RegistrationRequest() ;
       //  request.setDepartment(department);
         request.setEcnumber(ecnumber);
         request.setEmail(email);
         request.setFirstName(firstName);
         request.setLastName(lastName);
          String validNumber=  emailValidator.validaNumber(mobilenumber);
         validNumber="+263"+validNumber;
         request.setMobilenumber(validNumber);
         request.setPassword(password);
         request.setUsername(username);
      
         String validemail=  emailValidator.test(email);
         request.setEmail(validemail);
       
        System.out.println("ecnumber "+ecnumber);
        System.out.println("email "+validemail);
        System.out.println("firstName "+firstName);
        Long  department=checkString (departmentid);
         request.setDepartmentId(department);
        System.out.println("bb "+departmentid);
        String response=   registrationService.register(request); 
        if(response.equalsIgnoreCase("Success")){
             return "/singupverification?faces-redirect=true";
        }else{
             System.out.println(response);
          FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", response));
         
        }
        
         
         }catch(IllegalStateException ex){
             System.out.println(ex.getMessage());
          FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage()));
         }
     
         
       // FacesContext.getCurrentInstance().addMessage(null,
              //  new FacesMessage("Welcome "+response));
        return null;
    }
     public long checkString (Long department){
         if(department!=null){
             return department;
         }else{
              throw new IllegalStateException(String.format("Department %s, Department Not Selected", department));
         }
     }
    
}
