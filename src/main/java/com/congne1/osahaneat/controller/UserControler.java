package com.congne1.osahaneat.controller;

import com.congne1.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    UserServiceImp userServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getAlluser(){
        return new ResponseEntity<>(userServiceImp.getAllUser(), HttpStatus.OK);
    }
}
