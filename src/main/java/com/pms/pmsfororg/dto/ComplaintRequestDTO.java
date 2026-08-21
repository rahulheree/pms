package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ComplaintRequestDTO {

    @NotBlank
    private String subject;

    @NotBlank
    private String description;

    @NotBlank
    private String category;

    @NotBlank
    private String status;

    @NotNull
    private Long citizenId;

    @NotNull
    private Long wardId;

    public ComplaintRequestDTO() {}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public Long getWardId() {
        return wardId;
    }

    public void setWardId(Long wardId) {
        this.wardId = wardId;
    }
}
