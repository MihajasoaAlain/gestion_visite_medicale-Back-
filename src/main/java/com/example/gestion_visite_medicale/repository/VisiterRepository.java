package com.example.gestion_visite_medicale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion_visite_medicale.models.Visiter;

public interface VisiterRepository extends JpaRepository<Visiter,Integer> {
    
}
