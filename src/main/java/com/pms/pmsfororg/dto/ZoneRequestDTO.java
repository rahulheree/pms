package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotBlank;

public class ZoneRequestDTO {

    @NotBlank
    private String zoneName;

    public ZoneRequestDTO() {}

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}