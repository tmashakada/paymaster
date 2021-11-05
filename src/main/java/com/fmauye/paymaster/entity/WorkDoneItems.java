/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "work_done_items")
public class WorkDoneItems implements Serializable{
     @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

   

    @Column(nullable = false,name="created_at")
    
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    
   
    
    @ManyToOne
    @JoinColumn(nullable = false,  name = "item_id",referencedColumnName = "id")
    private Item item;
    
    @ManyToOne
    @JoinColumn(name = "work_done_id", referencedColumnName = "id")
    private WorkDone  workdone;
    
    private BigDecimal amount;

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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public WorkDone getWorkdone() {
        return workdone;
    }

    public void setWorkdone(WorkDone workdone) {
        this.workdone = workdone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    
}
