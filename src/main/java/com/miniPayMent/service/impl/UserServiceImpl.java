package com.miniPayMent.service.impl;

import com.miniPayMent.model.CreateUserDto;
import com.miniPayMent.model.UserDto;
import com.miniPayMent.repository.UserRepository;
import com.miniPayMent.repository.entity.UserEntity;
import com.miniPayMent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUser(String name, String personalId) {
        UserDto userDto = new UserDto();

        UserEntity userEntity = userRepository.findByNameAndPersonalId(name, personalId);
        userDto.setName(userEntity.getName());
        userDto.setAge(userEntity.getAge());
        userDto.setAddress(userEntity.getAddress());
        userDto.setPersonalId(userEntity.getPersonalId());
        userDto.setStatus(userEntity.getStatus());
        return userDto;
    }

    @Override
    public void createUser(CreateUserDto request) {
        UserEntity newUser = new UserEntity();

        newUser.setName(request.getName());
        newUser.setAddress(request.getAddress());
        newUser.setAge(request.getAge());
        newUser.setPersonalId(request.getPersonalId());
        newUser.setStatus("ACTIVE");
        newUser.setCreateAt(new java.util.Date());

        userRepository.save(newUser);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (UserEntity user : userEntityList) {
            UserDto userDto = new UserDto();
            userDto.setPersonalId(user.getPersonalId());
            userDto.setName(user.getName());
            userDto.setAge(user.getAge());
            userDto.setStatus(user.getStatus());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
