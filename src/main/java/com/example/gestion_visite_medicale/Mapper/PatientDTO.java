package com.example.gestion_visite_medicale.Mapper;

import lombok.Data;

@Data
public class PatientDTO {
    private Integer codepat;
    private String nom;
    private String prenom;
    private  String adresse;
    private String sexe;

}
