package com.miniPayMent.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private boolean success;
    private String message;
    private List<String> details = new ArrayList<>();
}
