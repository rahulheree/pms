package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WardRequestDTO {

    @NotNull
    private Integer wardNo;

    @NotBlank
    private String wardName;

    private String councillorName;

    @NotNull
    private Long zoneId;

    public WardRequestDTO() {}

    public Integer getWardNo() {
        return wardNo;
    }

    public void setWardNo(Integer wardNo) {
        this.wardNo = wardNo;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getCouncillorName() {
        return councillorName;
    }

    public void setCouncillorName(String councillorName) {
        this.councillorName = councillorName;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
