package com.pms.pmsfororg.dto;

public class WardResponseDTO {

    private Long id;
    private Integer wardNo;
    private String wardName;
    private String councillorName;
    private Long zoneId;
    private String zoneName;

    public WardResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
