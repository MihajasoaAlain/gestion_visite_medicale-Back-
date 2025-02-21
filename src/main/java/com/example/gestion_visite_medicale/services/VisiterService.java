package com.example.gestion_visite_medicale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Visiter;
import com.example.gestion_visite_medicale.repository.VisiterRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VisiterService {
     public VisiterRepository visiterRepository;

    public Visiter create(Visiter visiter) {
        return visiterRepository.save(visiter);
    }

    public List<Visiter> getAll() {
        return visiterRepository.findAll();
    }

    public Visiter findByVisiterId(int id) {
        return visiterRepository.findById(id).orElseThrow(null);

    }

    public Visiter delete(int id) {
        Visiter visiter = this.findByVisiterId(id);
        visiterRepository.delete(visiter);
        return visiter;
    }
}
