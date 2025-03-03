package com.example.gestion_visite_medicale.controllers;

import java.util.List;

import com.example.gestion_visite_medicale.Mapper.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.services.PatientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);


    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        try {
            List<PatientDTO> patients = patientService.getAll();
            if (patients.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des patients : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?>
    createPatient(@RequestBody PatientDTO patient) {
        try {
            PatientDTO savedPatient = patientService.create(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
        } catch (Exception e) {
            logger.error("Erreur lors de l'ajout du patient : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPatient(@PathVariable int id) {
        try {
            PatientDTO patient = patientService.findByPatientId(id);
            return ResponseEntity.ok(patient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient non trouvé : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable int id, @RequestBody PatientDTO newPatient) {
        try {
            PatientDTO updatedPatient = patientService.update(id, newPatient);
            return ResponseEntity.ok(updatedPatient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur de mise à jour : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable int id) {
        try {
            patientService.delete(id);
            return ResponseEntity.ok("Patient supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
