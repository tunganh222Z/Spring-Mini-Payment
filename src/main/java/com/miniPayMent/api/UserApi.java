package com.miniPayMent.api;

import com.miniPayMent.model.CreateUserDto;
import com.miniPayMent.model.ErrorResponse;
import com.miniPayMent.model.UserDto;
import com.miniPayMent.service.UserService;
import com.miniPayMent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping()
    public UserDto getUser (@RequestParam(name = "name", required = true) String name,
                            @RequestParam(name = "personalId", required = true) String personalId) {
        return userService.getUser(name, personalId);
    }

    @GetMapping(value = "/all-users")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(value = "/create")
    public ErrorResponse createUser(@RequestBody CreateUserDto request){
        ErrorResponse errorResponse = new ErrorResponse();
        userService.createUser(request);
        errorResponse.setSuccess(true);
        errorResponse.setMessage("Đã tạo user " + request.getName() + " với personalId " + request.getPersonalId());

        return errorResponse;
    }
}
