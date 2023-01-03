package com.MyRH.backend.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

@Data
public class RecruteurRequest {

    private Long id;
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String telephone;
    private MultipartFile image;
    private Date created_at;
    private Date updated_at;

}
