package com.pms.pmsfororg.dto;

public class LoginResponseDTO {

    private String token;
    private Long citizenId;
    private String username;
    private String role;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, Long citizenId,
                            String username, String role) {
        this.token = token;
        this.citizenId = citizenId;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
