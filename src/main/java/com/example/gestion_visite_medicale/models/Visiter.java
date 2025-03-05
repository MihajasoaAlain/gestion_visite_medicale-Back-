package com.example.gestion_visite_medicale.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Visiter {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "codemed",referencedColumnName = "codemed",nullable = false)
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "codepat",referencedColumnName = "codepat",nullable = false)
    private Patient patient;

    private LocalDate date;
    
}
