package com.congne1.osahaneat.service;

import com.congne1.osahaneat.dto.UserDto;
import com.congne1.osahaneat.entity.Roles;
import com.congne1.osahaneat.entity.Users;
import com.congne1.osahaneat.paylod.request.SignUpRequest;
import com.congne1.osahaneat.repository.UserRepository;
import com.congne1.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUser() {
        List<Users> listUser = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (Users users : listUser) {
            UserDto userDto = new UserDto();
            userDto.setId(users.getId());
            userDto.setFullName(users.getFullName());
            userDto.setUserName(users.getUserName());
            userDto.setPassword(users.getPassword());
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        Users user = userRepository.findByUserName(username);
        return passwordEncoder.matches(password, user.getPassword());// hàm matches so sánh hai password trả về true hay
                                                                     // false
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullName(signUpRequest.getFullname());
        users.setUserName(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());

        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
