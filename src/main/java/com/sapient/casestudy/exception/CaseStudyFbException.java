package com.sapient.casestudy.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CaseStudyFbException extends RuntimeException {
    Map<String, String> exceptionDetails = new HashMap<>();

    public CaseStudyFbException(String msg) {
        super(msg);
    }

    public CaseStudyFbException(Throwable t) {
        super(t);
    }

    public CaseStudyFbException(String s, Throwable t) {
        super(s, t);
    }
}
