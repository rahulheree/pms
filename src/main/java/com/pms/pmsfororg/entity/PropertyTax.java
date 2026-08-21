package com.pms.pmsfororg.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "property_taxes")
public class PropertyTax extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer taxYear;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    public PropertyTax() {
    }

    public Long getId() {
        return id;
    }

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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
