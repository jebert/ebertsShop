package com.eberts.shop.resources;

import com.eberts.shop.models.User;
import com.eberts.shop.models.vo.security.AccountCredentialsVo;
import com.eberts.shop.models.vo.security.TokenVo;
import com.eberts.shop.repositories.UserRepository;
import com.eberts.shop.security.jwt.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository repository;

    @Operation(summary = "Authenticates a user and returns a token")
    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin", produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity signin(@RequestBody AccountCredentialsVo data) {

            var username = data.getUsername();
            var password = data.getPassword();
            var user = repository.findByUserName(username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());

            authenticationManager.authenticate(usernamePasswordAuthenticationToken);


            TokenVo token;

            if (user != null) {
                token = tokenProvider.createAccessToken(user.getUsername(), user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + user.getUsername() + " not found!");
            }

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);

    }
}