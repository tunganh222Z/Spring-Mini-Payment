package com.miniPayMent.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorDto {
    private String error;
    private List<String> detail = new ArrayList<>();
}
