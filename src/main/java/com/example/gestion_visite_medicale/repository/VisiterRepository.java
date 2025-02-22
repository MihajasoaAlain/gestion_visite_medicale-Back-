package com.example.gestion_visite_medicale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.models.Visiter;
import java.util.List;


@Repository
public interface VisiterRepository extends JpaRepository<Visiter, Integer> {
List<Visiter> findByPatient(Patient patient);
}
