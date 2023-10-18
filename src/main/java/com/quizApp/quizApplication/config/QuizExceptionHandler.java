package com.quizApp.quizApplication.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class QuizExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> internalServerError(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Some error Occurred, Please contact administrator " + ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<Object> accessDenied(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Authentication Failed " + ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}