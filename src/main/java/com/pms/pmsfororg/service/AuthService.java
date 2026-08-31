package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.AuthRequestDTO;
import com.pms.pmsfororg.dto.LoginResponseDTO;
import com.pms.pmsfororg.dto.RegisterRequestDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.UserAccount;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserAccountRepository userAccountRepository;
    private final CitizenRepository citizenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserAccountRepository userAccountRepository,
            CitizenRepository citizenRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userAccountRepository = userAccountRepository;
        this.citizenRepository = citizenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequestDTO dto) {

        if (userAccountRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException(
                    "Username already exists"
            );
        }

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Citizen Not Found"
                        ));

        if (userAccountRepository.findByCitizenId(dto.getCitizenId())
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Citizen already has an account"
            );
        }

        UserAccount account = new UserAccount();

        account.setUsername(dto.getUsername());
        account.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );
        account.setRole("CITIZEN");
        account.setCitizen(citizen);

        userAccountRepository.save(account);

        return "Account created successfully";
    }

    public LoginResponseDTO login(AuthRequestDTO dto) {

        UserAccount account = userAccountRepository
                .findByUsername(dto.getUsername())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid username or password"
                        ));

        if (!passwordEncoder.matches(
                dto.getPassword(),
                account.getPassword())) {

            throw new IllegalArgumentException(
                    "Invalid username or password"
            );
        }

        String token = jwtService.generateToken(
                account.getUsername(),
                account.getCitizen().getId(),
                account.getRole()
        );

        return new LoginResponseDTO(
                token,
                account.getCitizen().getId(),
                account.getUsername(),
                account.getRole()
        );
    }
}
