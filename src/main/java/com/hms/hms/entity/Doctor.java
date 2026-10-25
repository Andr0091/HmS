package com.hms.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "doctors",
        uniqueConstraints = @UniqueConstraint( //unique(crm, crm_state)
                columnNames = { "crm", "crm_state" }
        )
)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "crm", nullable = false, length = 20)
    private String crm;

    @Column(name = "crm_state", nullable = false, length = 2)
    private String crmState;

    @Column(name = "specialty", nullable = false, length = 100)
    private String specialty;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getCrmState() { return crmState; }
    public void setCrmState(String crmState) { this.crmState = crmState; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}