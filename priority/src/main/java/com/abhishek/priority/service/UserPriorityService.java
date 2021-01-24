package com.abhishek.priority.service;

import com.abhishek.priority.dto.AssignUserPriorityObject;
import com.abhishek.priority.response.ResponseCodeJson;

public interface UserPriorityService {
    ResponseCodeJson assignPriority(AssignUserPriorityObject assignUserPriorityObject);
}
