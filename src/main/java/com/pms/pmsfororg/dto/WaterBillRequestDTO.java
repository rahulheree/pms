package com.pms.pmsfororg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class WaterBillRequestDTO {

    private String billNumber;

    @NotNull
    private Double amount;

    @NotNull
    private LocalDate billingDate;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private String status;

    @NotNull
    private Long citizenId;

    public WaterBillRequestDTO() {}

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
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
}
