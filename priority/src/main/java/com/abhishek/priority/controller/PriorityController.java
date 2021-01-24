package com.abhishek.priority.controller;

import com.abhishek.priority.exception.PriorityExistsException;
import com.abhishek.priority.dto.AssignUserPriorityObject;
import com.abhishek.priority.exception.UsernameNotFondException;
import com.abhishek.priority.exception.ScaleNotInRangeException;
import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.response.UniversalResponse;
import com.abhishek.priority.service.PriorityService;
import com.abhishek.priority.service.UserPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("priority")
@CrossOrigin
public class PriorityController {

    @Autowired
    private PriorityService priorityService;
    @Autowired
    private UserPriorityService userPriorityService;

    @PostMapping(value = "/addPriority/{priorityName}")
    public ResponseEntity<?> addPriority(@PathVariable String priorityName) throws Exception {
        ResponseCodeJson codeJson = priorityService.addPriorityType(priorityName.toLowerCase());
        if (codeJson.getCode() != 200) {
            throw new PriorityExistsException(codeJson.getMessage());
        }
        return new ResponseEntity<>(codeJson, HttpStatus.OK);
    }

    @PostMapping(value = "/assignPriority")
    public ResponseEntity<?> assignPriority(@Valid @RequestBody AssignUserPriorityObject assignUserPriorityObject) throws Exception {
        ResponseCodeJson codeJson = userPriorityService.assignPriority(assignUserPriorityObject);
        if (codeJson.getCode() != 200) {
            throw new ScaleNotInRangeException(codeJson.getMessage());
        }
        return new ResponseEntity<>(codeJson, HttpStatus.OK);
    }

    @GetMapping(value = "/getPriorityDetails/{userId}")
    public ResponseEntity<?> getSharedList(@PathVariable long userId) throws Exception{
        UniversalResponse ur = priorityService.getPriorityDetails(userId);
        ResponseCodeJson codeJson = ur.getResponseCodeJson();
        if (codeJson.getCode() != 200) {
            throw new UsernameNotFondException(codeJson.getMessage());
        }
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }
}
