package com.miniPayMent.service.impl;

import com.miniPayMent.custom_exception.UserException;
import com.miniPayMent.model.request.CreateUserDto;
import com.miniPayMent.model.response.UserDto;
import com.miniPayMent.repository.UserRepository;
import com.miniPayMent.repository.entity.UserEntity;
import com.miniPayMent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUser(String name, String personalId) {
        UserEntity userEntity = userRepository.findByNameAndPersonalId(name, personalId);
        if (userEntity == null) {
            throw new UserException(
                    "User not found",
                    HttpStatus.BAD_REQUEST,
                    400
            );
        }
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    @Override
    public void createUser(CreateUserDto request) {
        UserEntity newUser = modelMapper.map(request, UserEntity.class);
        newUser.setStatus("ACTIVE");
        newUser.setCreateAt(new java.util.Date());

        userRepository.save(newUser);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (UserEntity user : userEntityList) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
