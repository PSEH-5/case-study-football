package com.sapient.casestudy.advice.exceptionhandler;

import com.sapient.casestudy.exception.CaseStudyFbException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FbExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {Exception.class, Error.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Some error occurred. Verify input values.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value
            = {CaseStudyFbException.class})
    protected ResponseEntity<Object> handleCustomConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getLocalizedMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}