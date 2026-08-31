package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.AuthRequestDTO;
import com.pms.pmsfororg.dto.LoginResponseDTO;
import com.pms.pmsfororg.dto.RegisterRequestDTO;
import com.pms.pmsfororg.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequestDTO dto) {

        return authService.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody AuthRequestDTO dto) {

        return authService.login(dto);
    }
}
