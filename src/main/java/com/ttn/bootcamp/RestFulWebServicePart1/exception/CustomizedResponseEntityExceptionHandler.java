package com.ttn.bootcamp.RestFulWebServicePart1.exception;

import com.ttn.bootcamp.RestFulWebServicePart1.Employee.EmployeeNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundExecption.class)
    public final ResponseEntity<Object> handleEmployeeNotFoundExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
