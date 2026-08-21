package com.pms.pmsfororg.dto;

public class ZoneResponseDTO {

    private Long id;
    private String zoneName;

    public ZoneResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}