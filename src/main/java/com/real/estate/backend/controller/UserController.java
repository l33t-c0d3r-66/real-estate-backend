package com.real.estate.backend.controller;

import com.real.estate.backend.model.UserInformation;
import com.real.estate.backend.security.model.AuthRequest;
import com.real.estate.backend.security.service.JWTService;
import com.real.estate.backend.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping(value = "/api/v1/register")
    public HashMap<String, Object> registerUser(@RequestBody UserInformation userInformation) {
        HashMap<String, Object> response = new HashMap<>();
        UserInformation userInfo = userInformationService.addUser(userInformation);
        if(userInfo != null) {
            response.put("message", "User is Registered Successfully");
        } else {
            response.put("error", "Email already registered");
        }
        return response;
    }

    @PostMapping(value="/api/public/login")
    public HashMap<String, Object> authenticate(@RequestBody AuthRequest authRequest) {
        HashMap<String, Object> response = new HashMap<>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsername());
            response.put("message", "User Authenticated Successfully");
            response.put("token", token);
        } else {
            response.put("message", "Failed to Authenticate User");
        }
        return response;
    }

    @PostMapping(value="/api/v1/validate/{token}")
    public HashMap<String, Object> validateToken(@PathVariable("token") String token) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
