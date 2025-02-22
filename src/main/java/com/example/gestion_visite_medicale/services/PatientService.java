package com.example.gestion_visite_medicale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient findByPatientId(int codepat) {
        return patientRepository.findById(codepat)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé avec ID : " + codepat));
    }

    public Patient delete(int codepat) {
        Patient patient = this.findByPatientId(codepat);
        patientRepository.delete(patient);
        return patient;
    }

    public Patient update(int codepat, Patient newPatient) {
        Patient existingPatient = this.findByPatientId(codepat);

        existingPatient.setNom(newPatient.getNom());
        existingPatient.setPrenom(newPatient.getPrenom()); 

        return patientRepository.save(existingPatient);
    }
}
