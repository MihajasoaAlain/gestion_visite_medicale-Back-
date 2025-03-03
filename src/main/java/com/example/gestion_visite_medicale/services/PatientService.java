package com.example.gestion_visite_medicale.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gestion_visite_medicale.Mapper.PatientDTO;
import com.example.gestion_visite_medicale.Mapper.PatientMapper;
import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientDTO create(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        return patientMapper.toDto(patientRepository.save(patient));
    }

    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDto)
                .collect(Collectors.toList());
    }

    public PatientDTO findByPatientId(int codepat) {
        Patient patient = patientRepository.findById(codepat)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé avec ID : " + codepat));
        return patientMapper.toDto(patient);
    }

    public void delete(int codepat) {
        Patient patient = patientRepository.findById(codepat)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé avec ID : " + codepat));
        patientRepository.delete(patient);
    }

    public PatientDTO update(int codepat, PatientDTO newPatientDTO) {
        Patient existingPatient = patientRepository.findById(codepat)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé avec ID : " + codepat));

        existingPatient.setNom(newPatientDTO.getNom());
        existingPatient.setPrenom(newPatientDTO.getPrenom());
        existingPatient.setSexe(newPatientDTO.getSexe());
        existingPatient.setAdresse(newPatientDTO.getAdresse());

        return patientMapper.toDto(patientRepository.save(existingPatient));
    }
}
