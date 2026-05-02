package com.miniPayMent.model.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String personalId;
    private String status;


    public String toString() {
        return "Dữ liệu của UserData là " + this.name + "và tuổi " + this.age + "và địa chỉ " + this.address;
    }
}
