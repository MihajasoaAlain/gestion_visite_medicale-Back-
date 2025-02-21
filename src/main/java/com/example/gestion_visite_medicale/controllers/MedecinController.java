package com.example.gestion_visite_medicale.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_visite_medicale.models.Medecin;
import com.example.gestion_visite_medicale.repository.MedecinRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor


public class MedecinController {
    public MedecinRepository medecinRepository;

    public List<Medecin> getAll(){
        return medecinRepository.findAll();
    }
}
