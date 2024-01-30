package com.congne1.osahaneat.utils;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component//ko xử lý logic code

public class JwtUtilsHelper {
    // sinh ra token
    //@Value("${jwt.privateKey}") // lấy chìa
    @Value("${jwt.privateKey}")
    private String privateKey;// lưu lại

    public String generateToken(String data) {
        //trả về token
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;
    }
    public boolean verifyToken(String token){

        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
