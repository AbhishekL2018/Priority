package com.abhishek.priority.service;

import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.response.UniversalResponse;

public interface PriorityService {
    ResponseCodeJson addPriorityType(String priorityName);

    UniversalResponse getPriorityDetails(long userId);
}
