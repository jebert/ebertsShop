package com.eberts.shop.services;

import com.eberts.shop.models.vo.security.AccountCredentialsVo;
import com.eberts.shop.models.vo.security.TokenVo;
import com.eberts.shop.repositories.UserRepository;
import com.eberts.shop.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);
    }

    public ResponseEntity signIn (AccountCredentialsVo vo){
        try {
            var userName = vo.getUsername();
            var password = vo.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));

            var user = userRepository.findByUserName(userName);
            var tokenResponse = new TokenVo();

            if (user != null){
                tokenResponse = jwtTokenProvider.createAccessToken(userName, user.getRoles());
            }else {
                throw new UsernameNotFoundException("Username "+ userName+" not found!");
            }


            return ResponseEntity.ok(tokenResponse);
        }catch (Exception e){
            throw new BadCredentialsException("Invalid username/password");
        }
    }
}
