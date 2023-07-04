package com.iftm.api.prontuarioplus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{
    public RequiredObjectIsNullException(String message) {
        super(message);
    }
}