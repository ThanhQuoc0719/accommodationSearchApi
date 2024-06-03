package com.example.spring_boot_api.response;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String avatar;
    private String role;
    private String selfIntroduction;
}
