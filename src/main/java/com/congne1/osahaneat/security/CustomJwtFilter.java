package com.congne1.osahaneat.security;

import com.congne1.osahaneat.utils.JwtUtilsHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class CustomJwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtilsHelper utilsHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromHeard(request);//lấy hearder
        if(token != null){
            if(utilsHelper.verifyToken(token)){//giải mã tken
                //tạo chứng thực
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("","",new ArrayList<>());
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(usernamePasswordAuthenticationToken);

            }
        }


        filterChain.doFilter(request,response);
    }
    private String getTokenFromHeard(HttpServletRequest request){
        String header = request.getHeader("Authorization");//lấy nội dung hearder
        String token = null;
        if(StringUtils.hasText(header)&&header.startsWith("Bearer ")){//lấy nội dung lưu trên hearder
            token = header.substring(7);
        }
        return token;
    }
}
