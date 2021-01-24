package com.abhishek.priority.controller;

import com.abhishek.priority.exception.UsernameExistsException;
import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserControlller {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser/{userName}")
    public ResponseEntity<?> getSharedList(@PathVariable String userName) throws UsernameExistsException {
        ResponseCodeJson codeJson = userService.addUser(userName.toLowerCase());
        if (codeJson.getCode() != 200) {
            throw new UsernameExistsException(codeJson.getMessage());
        }
        return new ResponseEntity<>(codeJson, HttpStatus.OK);
    }
}
