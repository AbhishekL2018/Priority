package com.abhishek.priority.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "userPriorityMapping")
public class UserPriorityMapping {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "priorityScale")
    private int priorityScale;

    @Column(name = "userId")
    private long userId;

    @Column(name = "priorityId")
    private long priorityId;

    @Column(name = "priorityOrder")
    private int priorityOrder;

    @Column(name = "deleted")
    private boolean deleted = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriorityScale() {
        return priorityScale;
    }

    public void setPriorityScale(int priorityScale) {
        this.priorityScale = priorityScale;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(int priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
