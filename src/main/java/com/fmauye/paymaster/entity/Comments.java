/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author "Tafadzwa"
 */
@Entity
public class Comments implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

   

    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(name = "work_done_id", referencedColumnName = "id")
    private WorkDone  workdone;
    
    @Column(nullable = false)
    private String description;
 
    @ManyToOne
    @JoinColumn(nullable = false,  name = "comment_by_id",referencedColumnName = "id")
    private Users  commentBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public WorkDone getWorkdone() {
        return workdone;
    }

    public void setWorkdone(WorkDone workdone) {
        this.workdone = workdone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(Users commentBy) {
        this.commentBy = commentBy;
    }
    
    
}
