package com.MyRH.backend.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ClientRequest {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Date created_at;
    private Date updated_at;

}
