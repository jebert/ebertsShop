package com.eberts.shop.services;

import com.eberts.shop.models.vo.security.AccountCredentialsVo;
import com.eberts.shop.models.vo.security.TokenVo;
import com.eberts.shop.security.jwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthService {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private UserService userService;

    public ResponseEntity signin (AccountCredentialsVo data) throws Exception{
        try {
            var username = data.getUsername();
            var password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

            var user = userService.findUserByUsername(username);
            var tokenResponse = new TokenVo();

            if (user != null) {
                tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
            }else {
                throw new UsernameNotFoundException("Username not found!");
            }
            return  ResponseEntity.ok(tokenResponse);
        }catch (Exception e){
            throw new BadCredentialsException("Invalid Username/Password provided!");
        }
    }


}
