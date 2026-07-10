package com.emr_backend.service;

import com.emr_backend.entity.User;
import com.emr_backend.repository.UserRepository;
import com.emr_backend.dto.LoginRequest;
import com.emr_backend.dto.LoginResponse;

import org.springframework.stereotype.Service;


@Service
public class AuthService {


    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }



    public LoginResponse login(LoginRequest request) {


        User user = userRepository
                .findByUsername(request.getUsername())
                .orElse(null);



        // User does not exist
        if (user == null) {

            return new LoginResponse(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );

        }



        // Check password
        if (!user.getPasswordHash()
                .equals(request.getPassword())) {


            return new LoginResponse(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );

        }



        String role = user.getRole();


        // If role column is empty,
        // assign default role
        if (role == null || role.isEmpty()) {

            role = "User";

        }



        return new LoginResponse(
                true,
                "Login successful",
                user.getUsername(),
                role
        );

    }

}