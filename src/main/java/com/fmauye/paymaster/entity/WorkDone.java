/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @Column(nullable = false)
    private String token;

    @Column(nullable = false,name="created_at")
    
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    
     
    @ManyToOne
    @JoinColumn(name = "submitted_by_id", referencedColumnName = "id")
    private Users submittedBy;
    
    
    @ManyToOne
    @JoinColumn(name = "approved_by_hod_id", referencedColumnName = "id")
    private Users approvedByHod;
 
    @ManyToOne
    @JoinColumn(name = "approved_by_hr_id", referencedColumnName = "id")
    private Users approvedByHr;
    
    @Column(name="hod_status")
    private String hodStatus;
    
    @Column(name="hr_status")
    private String hrStatus;
    
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    @OneToMany(mappedBy = "workdone")
    private List<Comments> commentsList;
    
    @OneToMany(mappedBy = "workdone")
    private List<WorkDoneItems> workDoneItemsList;

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

    public Users getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Users submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Users getApprovedByHod() {
        return approvedByHod;
    }

    public void setApprovedByHod(Users approvedByHod) {
        this.approvedByHod = approvedByHod;
    }

    public Users getApprovedByHr() {
        return approvedByHr;
    }

    public void setApprovedByHr(Users approvedByHr) {
        this.approvedByHr = approvedByHr;
    }

    public String getHodStatus() {
        return hodStatus;
    }

    public void setHodStatus(String hodStatus) {
        this.hodStatus = hodStatus;
    }

    public String getHrStatus() {
        return hrStatus;
    }

    public void setHrStatus(String hrStatus) {
        this.hrStatus = hrStatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
    
    
    
}
