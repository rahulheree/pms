package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PropertyRequestDTO {

    @NotBlank
    private String propertyNumber;

    @NotBlank
    private String propertyType;

    @NotNull
    private Double area;

    @NotBlank
    private String address;

    @NotNull
    private Long ownerId;

    @NotNull
    private Long wardId;

    public PropertyRequestDTO() {}

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getWardId() {
        return wardId;
    }

    public void setWardId(Long wardId) {
        this.wardId = wardId;
    }
}