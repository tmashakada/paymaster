/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmauye.paymaster.dto.ItemDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author "Tafadzwa"
 */

@Entity
@Table(name = "work_done")
public class WorkDone implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String token;

    
    @Column(nullable = false,name="created_at")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    
     
    
    private String submittedBy;
    
    
   
    private String  username;
 
    
   
    
    @Column(name="status")
    private String status;
    
    
    private String department;
    
    @OneToMany(mappedBy = "workdone")
    private List<Comments> commentsList;
    
    @OneToMany(mappedBy = "workdone", fetch=FetchType.EAGER  )
    private List<WorkDoneItems> workDoneItemsList;

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
   


    

    

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<WorkDoneItems> getWorkDoneItemsList() {
        
        
                     
        return workDoneItemsList;
    }

    public void setWorkDoneItemsList(List<WorkDoneItems> workDoneItemsList) {
        this.workDoneItemsList = workDoneItemsList;
    }
     public String getTotalRevenue() {
		if (this.workDoneItemsList == null) {
			return "0";
		}
                BigDecimal totalRevenue = BigDecimal.ZERO;
                for(WorkDoneItems workDoneItems:workDoneItemsList){
                     totalRevenue = totalRevenue.add(workDoneItems.getTotalamount());
                }
            
		return new DecimalFormat("###,###.###").format(totalRevenue);
    //    return null;
        
	}
    
     
    
    
}
