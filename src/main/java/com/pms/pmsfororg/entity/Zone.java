package com.pms.pmsfororg.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zones")
public class Zone extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String zoneName;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<Ward> wards = new ArrayList<>();

    public Zone() {
    }

    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }
}
