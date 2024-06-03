package com.example.spring_boot_api.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String email;
    private String phoneNumber;
    private String avatar;
    private String password;
    private String username;
    private String selfIntroduction;
}
