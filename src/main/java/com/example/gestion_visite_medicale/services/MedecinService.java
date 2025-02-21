package com.example.gestion_visite_medicale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Medecin;
import com.example.gestion_visite_medicale.repository.MedecinRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedecinService {
    public MedecinRepository medecinRepository;

    public Medecin create(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> getAll() {
        return medecinRepository.findAll();
    }

    public Medecin findByMedecinId(int codemed) {
        return medecinRepository.findById(codemed).orElseThrow(null);

    }

    public Medecin delete(int codemed) {
        Medecin medecin = this.findByMedecinId(codemed);
        medecinRepository.delete(medecin);
        return medecin;
    }

}
