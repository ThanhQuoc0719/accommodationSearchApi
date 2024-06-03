package com.example.spring_boot_api.request;

import lombok.Data;

@Data
public class UserStatusRequest {
    private Long userId;
    private boolean locked;
}
