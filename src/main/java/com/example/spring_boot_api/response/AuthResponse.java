package com.example.spring_boot_api.response;
import lombok.Data;
@Data
public class AuthResponse {
    private String token;
    private UserDto user;
    private boolean status;

    public AuthResponse(String token, UserDto user, boolean status) {
        this.token = token;
        this.user = user;
        this.status = status;
    }


    // Getters and setters
}
