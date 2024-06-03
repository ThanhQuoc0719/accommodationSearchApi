package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.response.AuthResponse;
import com.example.spring_boot_api.response.JwtResponse;
import com.example.spring_boot_api.response.UserDto;
import com.example.spring_boot_api.service.CustomUserDetailsService;
import com.example.spring_boot_api.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Api(tags = "Authentication")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    @ApiOperation(value = "Sign up a new user")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        try {
            User newUser = userService.signUp(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "Authenticate user and generate JWT token")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {

            UserDetails userDetails = customUserDetailsService.loadUserByEmail(user.getEmail());
            if (!passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
                throw new RuntimeException("Incorrect password");
            }
            final String token = jwtTokenUtil.generateToken(userDetails);
            UserDto userDto = userService.getUserDtoByEmail(user.getEmail());
            AuthResponse authResponse = new AuthResponse(token, userDto, true);
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
