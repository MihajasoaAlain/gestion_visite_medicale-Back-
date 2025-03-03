package com.example.gestion_visite_medicale.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Patient {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer codepat;
private String nom;
private String prenom;
private String sexe;
private String adresse;
@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Visiter> visites;

}
