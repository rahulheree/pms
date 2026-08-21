package com.pms.pmsfororg.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "water_bills")
public class WaterBill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String billNumber;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate billingDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    public WaterBill() {
    }

    public Long getId() {
        return id;
    }

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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
