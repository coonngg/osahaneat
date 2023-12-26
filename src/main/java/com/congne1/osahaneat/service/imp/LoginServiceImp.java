package com.congne1.osahaneat.service.imp;

import com.congne1.osahaneat.dto.UserDto;
import com.congne1.osahaneat.paylod.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDto> getAllUser();
    boolean checkLogin(String username,String password);
    boolean addUser(SignUpRequest signUpRequest);
}
