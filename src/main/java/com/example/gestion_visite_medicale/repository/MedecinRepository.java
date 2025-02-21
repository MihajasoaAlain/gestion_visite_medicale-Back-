package com.example.gestion_visite_medicale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion_visite_medicale.models.Medecin;
    
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Integer> {

}