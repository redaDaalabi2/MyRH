package com.MyRH.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "recruteur")
public class Recruteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @GenericGenerator(name = "identifiant", strategy = "uuid2")
    @Column(name = "identifiant", unique = true)
    private String identifiant;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "image", nullable = false)
    private String image;

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
