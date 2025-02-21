package com.example.gestion_visite_medicale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    public PatientRepository patientRepository;

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient findByPatientId(int codepat) {
        return patientRepository.findById(codepat).orElseThrow(null);

    }

    public Patient delete(int codepat) {
        Patient patient = this.findByPatientId(codepat);
        patientRepository.delete(patient);
        return patient;
    }

}
