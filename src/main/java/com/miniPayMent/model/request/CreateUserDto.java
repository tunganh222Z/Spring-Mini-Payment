package com.miniPayMent.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String name;
    private int age;
    private String address;
    private String personalId;
}
