package com.example.gestion_visite_medicale.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_visite_medicale.models.Medecin;
import com.example.gestion_visite_medicale.services.MedecinService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/medecins")
@CrossOrigin(origins = "*") // Permet l'accès à l'API depuis un autre domaine
public class MedecinController {

    private final MedecinService medecinService;
    private static final Logger logger = LoggerFactory.getLogger(MedecinController.class);

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @GetMapping
    public ResponseEntity<List<Medecin>> getAllMedecins() {
        try {
            List<Medecin> medecins = medecinService.getAll();
            if (medecins.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(medecins);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des médecins : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createMedecin(@RequestBody Medecin medecin) {
        try {
            Medecin savedMedecin = medecinService.create(medecin);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMedecin);
        } catch (Exception e) {
            logger.error("Erreur lors de l'ajout du médecin : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur lors de l'ajout du médecin : " + e.getMessage());
        }
    }

    @GetMapping("/{codemed}")

    public ResponseEntity<?> findMedecin(@PathVariable int codemed) {

        try {
            Medecin medecinFind = medecinService.findByMedecinId(codemed);
            return ResponseEntity.ok(medecinFind);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur Medecin non trouver : " + e.getMessage());
        }
    }

    @PutMapping("/{codemed}")
    public ResponseEntity<?> updateMedecin(@PathVariable int codemed, @RequestBody Medecin newMedecin) {
        try {
            Medecin updatedMedecin = medecinService.update(codemed, newMedecin);
            return ResponseEntity.ok(updatedMedecin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    @DeleteMapping("/{codemed}")

    public ResponseEntity<?> deleteMedecin(@PathVariable int codemed) {
        try {
            Medecin deletedMedecin = medecinService.delete(codemed);
            return ResponseEntity.ok(deletedMedecin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur lors de la mise suppression: " + e.getMessage());
        }
    }

}
