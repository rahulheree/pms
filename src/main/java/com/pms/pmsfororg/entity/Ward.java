package com.pms.pmsfororg.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wards")
public class Ward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer wardNo;

    @Column(nullable = false)
    private String wardName;

    private String councillorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @OneToMany(mappedBy = "ward")
    private List<Citizen> citizens = new ArrayList<>();

    @OneToMany(mappedBy = "ward")
    private List<Property> properties = new ArrayList<>();

    @OneToMany(mappedBy = "ward")
    private List<Complaint> complaints = new ArrayList<>();

    public Ward() {
    }

    public Long getId() {
        return id;
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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }
}