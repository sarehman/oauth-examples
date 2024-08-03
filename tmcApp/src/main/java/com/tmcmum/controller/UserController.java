package com.tmcmum.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmcmum.exception.ResourceNotFoundException;
import com.tmcmum.model.User;
import com.tmcmum.repository.UserRepository;
import com.tmcmum.security.CurrentUser;
import com.tmcmum.security.UserPrincipal;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
