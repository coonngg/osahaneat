package com.congne1.osahaneat.controller;

import com.congne1.osahaneat.paylod.ResponseData;
import com.congne1.osahaneat.paylod.request.SignUpRequest;
import com.congne1.osahaneat.repository.UserRepository;
import com.congne1.osahaneat.service.LoginService;
import com.congne1.osahaneat.service.imp.LoginServiceImp;
import com.congne1.osahaneat.utils.JwtUtilsHelper;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.beans.Encoder;
import java.util.Base64;

@RestController
@RequestMapping("/login")
public class logincontroller {

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;
    @PostMapping("/signin")
    public ResponseEntity<?> sigin(@RequestParam String username,@RequestParam String password){
        ResponseData responseData = new ResponseData();


    if (loginServiceImp.checkLogin(username,password)){
        String token =  jwtUtilsHelper.generateToken(username);
        responseData.setData(token);

    } else{
        responseData.setData("");
        responseData.setSuccess(false);
    }

    return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> sigup(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
