package com.miniPayMent.service;

import com.miniPayMent.model.request.CreateUserDto;
import com.miniPayMent.model.response.UserDto;

import java.util.List;

public interface UserService {
    public UserDto getUser(String name, String personalId);
    void createUser(CreateUserDto request);
    List<UserDto> getAllUser();
}
