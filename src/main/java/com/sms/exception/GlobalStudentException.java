package com.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalStudentException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<?> globalStudentException(Exception st, WebRequest webRequest) {
        ExceptionResponse ex = new ExceptionResponse(new Date(), st.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
}
