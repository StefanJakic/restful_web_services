package com.udemyIn28minutes.rest.webervices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundexception extends RuntimeException {
    public UserNotFoundexception(String message) {
        super(message);
    }
}
