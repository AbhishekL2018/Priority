package com.abhishek.priority.exception;

import com.abhishek.priority.response.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({UsernameExistsException.class, PriorityExistsException.class, ScaleNotInRangeException.class})
    ResponseEntity<?> duplicateEntryException(Exception ex, ServletWebRequest request){
        APIError error = new APIError();
        error.setTimeStamp(LocalDateTime.now());
        error.setPathUri(request.getDescription(true));
        error.setStatus(HttpStatus.FORBIDDEN);
        error.setErrors(Arrays.asList(ex.getMessage()));

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());

    }

    @ExceptionHandler({UsernameNotFondException.class})
    ResponseEntity<?> notFondException(Exception ex, ServletWebRequest request){
        APIError error = new APIError();
        error.setTimeStamp(LocalDateTime.now());
        error.setPathUri(request.getDescription(true));
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setErrors(Arrays.asList(ex.getMessage()));

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());

    }
}
