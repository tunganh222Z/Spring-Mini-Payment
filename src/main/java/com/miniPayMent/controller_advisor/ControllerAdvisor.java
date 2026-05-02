package com.miniPayMent.controller_advisor;

import com.miniPayMent.custom_exception.UserException;
import com.miniPayMent.custom_exception.WalletException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> userException(UserException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("message", ex.getMessage());
        error.put("timeStamp", System.currentTimeMillis());
        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(WalletException.class)
    public ResponseEntity<?> walletException(WalletException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("message", ex.getMessage());
        error.put("timeStamp", System.currentTimeMillis());
        return ResponseEntity.status(ex.getStatus()).body(error);
    }
}
