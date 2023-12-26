package com.congne1.osahaneat.service;

import com.congne1.osahaneat.dto.UserDto;
import com.congne1.osahaneat.entity.Users;
import com.congne1.osahaneat.repository.UserRepository;
import com.congne1.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDto> getAllUser() {
        List<Users> listUser = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for(Users users : listUser){
            UserDto userDto = new UserDto();
            userDto.setId(users.getId());
            userDto.setFullName(users.getFullName());
            userDto.setUserName(users.getUserName());
            userDto.setPassword(users.getPassword());
            userDtoList.add(userDto);
        }

        return userDtoList;
    }
}
