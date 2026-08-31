package com.pms.pmsfororg.dto;

import java.util.List;

public class CitizenDashboardDTO {

    private Long citizenId;
    private String citizenName;
    private String email;

    private List<PropertyResponseDTO> properties;
    private List<PropertyTaxResponseDTO> propertyTaxes;
    private List<WaterBillResponseDTO> waterBills;
    private List<ComplaintResponseDTO> complaints;

    public CitizenDashboardDTO() {
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PropertyResponseDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyResponseDTO> properties) {
        this.properties = properties;
    }

    public List<PropertyTaxResponseDTO> getPropertyTaxes() {
        return propertyTaxes;
    }

    public void setPropertyTaxes(List<PropertyTaxResponseDTO> propertyTaxes) {
        this.propertyTaxes = propertyTaxes;
    }

    public List<WaterBillResponseDTO> getWaterBills() {
        return waterBills;
    }

    public void setWaterBills(List<WaterBillResponseDTO> waterBills) {
        this.waterBills = waterBills;
    }

    public List<ComplaintResponseDTO> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<ComplaintResponseDTO> complaints) {
        this.complaints = complaints;
    }
}
