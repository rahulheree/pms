package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PropertyTaxRequestDTO {

    private String taxNumber;

    @NotNull
    private Double amount;

    @NotNull
    private Integer taxYear;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private String status;

    @NotNull
    private Long citizenId;

    @NotNull
    private Long propertyId;

    public PropertyTaxRequestDTO() {}

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(Integer taxYear) {
        this.taxYear = taxYear;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
