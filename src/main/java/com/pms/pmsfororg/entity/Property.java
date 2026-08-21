package com.pms.pmsfororg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String propertyNumber;

    @Column(nullable = false)
    private String propertyType;

    private Double area;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    public Property() {
    }

    public Long getId() {
        return id;
    }

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

    public Citizen getOwner() {
        return owner;
    }

    public void setOwner(Citizen owner) {
        this.owner = owner;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }
}
