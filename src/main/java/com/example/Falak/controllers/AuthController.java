package com.example.Falak.controllers;

import com.example.Falak.model.AuthenticationRequest;
import com.example.Falak.model.AuthenticationResponse;
import com.example.Falak.model.MyUserDetails;
import com.example.Falak.model.Role;
import com.example.Falak.services.MyUserDetailsService;
import com.example.Falak.util.JWTUtil;
import io.jsonwebtoken.Claims;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController

public class AuthController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private MyUserDetailsService myUserDetailsService;

        @Autowired
        private JWTUtil jwtUtil;


        @PostMapping("/auth")
        public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

            System.out.println("NEW AUTH REQUEST");

            try{
                System.out.println("Testing: in login method, email:"+authenticationRequest.getEmail()+"\n password:"+authenticationRequest.getPassword());

                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
                System.out.println("Bad Credentials");
                throw new Exception("Incorrect Email/Password",e);
           }

            final MyUserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);
            System.out.println("Testing: Out off login method, JWT:"+jwt);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));

        }

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal MyUserDetails user){

            return "Hello"+ user.getUsername();

    }




}
