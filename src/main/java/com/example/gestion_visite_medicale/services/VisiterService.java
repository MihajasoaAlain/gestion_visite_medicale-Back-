package com.example.gestion_visite_medicale.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gestion_visite_medicale.Mapper.PatientDTO;
import com.example.gestion_visite_medicale.Mapper.PatientMapper;
import org.springframework.stereotype.Service;

import com.example.gestion_visite_medicale.Mapper.VisiterDTO;
import com.example.gestion_visite_medicale.Mapper.VisiterMapper;
import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.models.Visiter;
import com.example.gestion_visite_medicale.repository.VisiterRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VisiterService {
    public VisiterRepository visiterRepository;
    private PatientService patientService;
    private final VisiterMapper visiterMapper;
    private  final PatientMapper patientMapper;

    public Visiter create(Visiter visiter) {
        return visiterRepository.save(visiter);
    }

     public List<VisiterDTO> getAll() {
        return visiterRepository.findAll().stream()
                .map(visiterMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<VisiterDTO> getAllVisityByPatient(int codepat) {
        Patient patientFind = patientMapper.toEntity(patientService.findByPatientId(codepat));

        if (patientFind == null) {
            throw new IllegalArgumentException("Patient non trouvé avec le code : " + codepat);
        }

        return visiterRepository.findByPatient(patientFind).stream()
                .map(visiterMapper::toDto)
                .collect(Collectors.toList());
    }

    public VisiterDTO findByVisiterId(int id) {
        Visiter visiterResult = visiterRepository.findById(id).orElseThrow(null);
        return visiterMapper.toDto(visiterResult);

    }

    public VisiterDTO updateVisiter(int id, Visiter newVisiter) {
        Visiter existingVisiter = visiterMapper.toEntity(this.findByVisiterId(id));
        existingVisiter.setDate(newVisiter.getDate());
        return visiterMapper.toDto(visiterRepository.save(existingVisiter)) ;

    }

    public VisiterDTO delete(int id) {
        Visiter visiter = visiterMapper.toEntity(this.findByVisiterId(id));
        visiterRepository.delete(visiter);
        return visiterMapper.toDto(visiter);
    }
}
