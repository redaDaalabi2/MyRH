package com.MyRH.backend.dto;

import lombok.Data;

@Data
public class OffreRequest {

    private Long id;
    private String titre;
    private String description;
    private String ville;
    private Integer nbr_postulation;
    private String niveau;
    private String profile;
    private Float salaire;
    private String statut;
    private Long recruteur_id;
    private String created_at;
    private String updated_at;

}
