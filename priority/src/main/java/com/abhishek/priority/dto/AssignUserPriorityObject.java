package com.abhishek.priority.dto;


import java.util.List;

public class AssignUserPriorityObject {
    private long userId;
    private List<PriorityObject> priorityObjectList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<PriorityObject> getPriorityObjectList() {
        return priorityObjectList;
    }

    public void setPriorityObjectList(List<PriorityObject> priorityObjectList) {
        this.priorityObjectList = priorityObjectList;
    }
}
