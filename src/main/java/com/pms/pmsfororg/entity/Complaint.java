package com.pms.pmsfororg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private String status;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    public Complaint() {
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }
}
