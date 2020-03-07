package com.sapient.casestudy.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CaseStudyException extends RuntimeException {
    Map<String, String> exceptionDetails = new HashMap<>();

    public CaseStudyException(String msg) {
        super(msg);
    }

    public CaseStudyException(Throwable t) {
        super(t);
    }

    public CaseStudyException(String s, Throwable t) {
        super(s, t);
    }
}
