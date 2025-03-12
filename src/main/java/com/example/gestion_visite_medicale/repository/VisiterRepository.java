package com.example.gestion_visite_medicale.repository;

import com.example.gestion_visite_medicale.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.models.Visiter;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface VisiterRepository extends JpaRepository<Visiter, Integer> {
List<Visiter> findByPatient(Patient patient);
    boolean existsByMedecinAndDate(Medecin medecin, LocalDateTime date);
}
