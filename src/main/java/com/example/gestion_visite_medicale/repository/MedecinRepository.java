package com.example.gestion_visite_medicale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion_visite_medicale.models.Medecin;

public interface MedecinRepository extends JpaRepository <Medecin,Integer> {

} 