package com.miniPayMent.custom_exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends RuntimeException {
    private final HttpStatus status;
    private final int code;

    public UserException(String message, HttpStatus status, int code) {
        super(message);
        this.status = status;
        this.code = code;
    }
}
