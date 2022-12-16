package com.example.BloodBank.controller;

import com.example.BloodBank.Utils.JwtUtil;
import com.example.BloodBank.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String weclcome() {
        return  "Welcome";
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName()
                            ,authRequest.getPassword())
            );
        } catch (Exception ex){
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
