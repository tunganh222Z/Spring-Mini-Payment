package com.miniPayMent.custom_exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class WalletException extends RuntimeException {
    private final HttpStatus status;
    private final int code;

    public WalletException(String message, HttpStatus status, int code) {
        super(message);
        this.status = status;
        this.code = code;
    }
}
