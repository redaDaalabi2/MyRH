package com.myrh.models;

import com.myrh.utils.Enum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "description", nullable = false)
    private String description;

    @Basic
    @Column(name = "location", nullable = false)
    private String location;

    @Basic
    @Column(name = "degree", nullable = false)
    private String degree;

    @Basic
    @Column(name = "salary")
    private Double salary;

    @Basic
    @Column(name = "status", nullable = false)
    private String status;

    @Basic
    @Column(name = "profile_id")
    private Long profileId;

    @ManyToOne
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private Profile profile;

    @Basic
    @Column(name = "company_id")
    private Long companyId;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @Basic
    @Column
    private Date created;

    @Basic
    @Column
    private Date updated;

    @PrePersist
    protected void onCreate(){
        this.created = new Date();
        this.updated = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated = new Date();
    }

    public Offer() {}

    public Offer(String title, String description, String location, String degree, Double salary, Long profileId, Long companyId) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.degree = degree;
        this.status = Enum.status.Pending.toString();
        this.profileId = profileId;
        this.companyId = companyId;
        if(salary != null){
            this.salary = salary;
        }
    }
}
