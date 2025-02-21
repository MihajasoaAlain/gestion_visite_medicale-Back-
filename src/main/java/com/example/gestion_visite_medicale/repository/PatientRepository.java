package com.example.gestion_visite_medicale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion_visite_medicale.models.Patient;

public interface PatientRepository extends JpaRepository <Patient,Integer> {

} 