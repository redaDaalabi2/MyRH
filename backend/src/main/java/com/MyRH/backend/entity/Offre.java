package com.MyRH.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "offre")
public class Offre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    @Column(name = "salaire", nullable = false)
    private Float salaire;

    @Column(name = "statut", nullable = false)
    private String statut;

    @Column(name = "Nbr_postulation", nullable = false)
    private Integer Nbr_postulation;

    @Column(name = "recruteur_id", nullable = false)
    private Long recruteur_id;

    @ManyToOne
    @JoinColumn(name = "recruteur_id", insertable = false, updatable = false)
    private Recruteur recruteur;

    @Basic
    @Column
    private Date created_at;

    @Basic
    @Column
    private Date updated_at;

    @PrePersist
    protected void onCreate(){
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }

}
