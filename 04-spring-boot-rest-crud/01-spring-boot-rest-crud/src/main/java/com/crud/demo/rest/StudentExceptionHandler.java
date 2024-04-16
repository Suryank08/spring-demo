package com.crud.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
  //  add exception handling code
    @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
            //create a studentErrorResponse
            StudentErrorResponse error =new StudentErrorResponse();
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(studentNotFoundException.getMessage());
            error.setTimeStamp(System.currentTimeMillis());
            //return th eresponse entity
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

        }
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleAllException(Exception exc){
            StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
            studentErrorResponse.setMessage(exc.getMessage());
            studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            studentErrorResponse.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
        }
}
