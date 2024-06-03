package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.repository.UserRepository;
import com.example.spring_boot_api.request.UserUpdateRequest;
import com.example.spring_boot_api.response.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signUp(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public UserDto getUserDtoByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return mapUserToDto(user);
    }

    public UserDto getUserDtoByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return mapUserToDto(user);
    }

    private UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAvatar(user.getAvatar());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public User updateUserStatus(Long userId, boolean locked) {
        User user = getUserById(userId);
        user.setLocked(locked);
        return userRepository.save(user);
    }

    public User updateUser(Long userId, UserUpdateRequest request) {
        User user = getUserById(userId);

        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            user.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getAvatar() != null) {
            user.setAvatar(request.getAvatar());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getSelfIntroduction() != null) {
            user.setSelfIntroduction(request.getSelfIntroduction());
        }

        return userRepository.save(user);
    }
}

