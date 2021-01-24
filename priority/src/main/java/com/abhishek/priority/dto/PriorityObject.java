package com.abhishek.priority.dto;

public class PriorityObject {
    private long priorityId;
    private int priorityScale;
    private int priorityOrder;

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public int getPriorityScale() {
        return priorityScale;
    }

    public void setPriorityScale(int priorityScale) {
        this.priorityScale = priorityScale;
    }

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(int priorityOrder) {
        this.priorityOrder = priorityOrder;
    }
}
