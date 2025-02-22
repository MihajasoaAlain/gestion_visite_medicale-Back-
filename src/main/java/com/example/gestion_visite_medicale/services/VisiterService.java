package com.example.gestion_visite_medicale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.models.Visiter;
import com.example.gestion_visite_medicale.repository.VisiterRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VisiterService {
    public VisiterRepository visiterRepository;
    private PatientService patientService;

    public Visiter create(Visiter visiter) {
        return visiterRepository.save(visiter);
    }

    public List<Visiter> getAll() {
        return visiterRepository.findAll();
    }

    public List<Visiter> getAllVisityByPatient(int codepat) {
        Patient patientFind = patientService.findByPatientId(codepat);

        if (patientFind == null) {
            throw new IllegalArgumentException("Patient non trouvé avec le code : " + codepat);
        }

        return visiterRepository.findByPatient(patientFind);
    }

    public Visiter findByVisiterId(int id) {
        return visiterRepository.findById(id).orElseThrow(null);

    }

    public Visiter updateVisiter(int id, Visiter newVisiter) {
        Visiter existingVisiter = this.findByVisiterId(id);
        existingVisiter.setDate(newVisiter.getDate());
        return visiterRepository.save(existingVisiter);

    }

    public Visiter delete(int id) {
        Visiter visiter = this.findByVisiterId(id);
        visiterRepository.delete(visiter);
        return visiter;
    }
}
