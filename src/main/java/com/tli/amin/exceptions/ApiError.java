package com.tli.amin.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Krishna Katepalli on 06/07/2017.
 */
public class ApiError {
    private HttpStatus status; //the HTTP status code
    private String message; //the error message associated with exception
    private List<String> errors; //List of constructed error i18n

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}

