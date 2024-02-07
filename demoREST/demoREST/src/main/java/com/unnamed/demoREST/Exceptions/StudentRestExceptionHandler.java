package com.unnamed.demoREST.Exceptions;

import com.unnamed.demoREST.Exceptions.StudentNotFoundException;
import com.unnamed.demoREST.Models.StudentErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponseModel> handleException(StudentNotFoundException exc){
        var error=new StudentErrorResponseModel();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<StudentErrorResponseModel>(error,HttpStatus.NOT_FOUND);
    }

    // general exception handler ... to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponseModel> handleException(Exception exc){
        var error=new StudentErrorResponseModel();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponseModel>(error,HttpStatus.BAD_REQUEST);

    }

}
