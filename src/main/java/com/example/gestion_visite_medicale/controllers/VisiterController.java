package com.example.gestion_visite_medicale.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_visite_medicale.Mapper.VisiterDTO;
import com.example.gestion_visite_medicale.models.Visiter;
import com.example.gestion_visite_medicale.services.VisiterService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/visiters")
@AllArgsConstructor
public class VisiterController {
    private final VisiterService visiterService;
    private static final Logger logger = LoggerFactory.getLogger(VisiterController.class);

    @GetMapping
    public ResponseEntity<List<VisiterDTO>> getAllVisite() {
        try {
            List<VisiterDTO> Visiters = visiterService.getAll();
            if (Visiters.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(Visiters);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des Visiters : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createVisiter(@RequestBody Visiter Visiter) {
        try {
            Visiter savedVisiter = visiterService.create(Visiter);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVisiter);
        } catch (Exception e) {
            logger.error("Erreur lors de l'ajout du Visiter : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findVisiter(@PathVariable int id) {
        try {
            VisiterDTO Visiter = visiterService.findByVisiterId(id);
            ;
            return ResponseEntity.ok(Visiter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visiter non trouvé : " + e.getMessage());
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> findAllVisiter(@PathVariable int id) {
        try {
            List<VisiterDTO> Visiter = visiterService.getAllVisityByPatient(id);
            return ResponseEntity.ok(Visiter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visiter non trouvé : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVisiter(@PathVariable int id, @RequestBody Visiter newVisiter) {
        try {
            VisiterDTO updatedVisiter = visiterService.updateVisiter(id, newVisiter);
            return ResponseEntity.ok(updatedVisiter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur de mise à jour : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVisite(@PathVariable int id) {
        try {
            visiterService.delete(id);
            return ResponseEntity.ok("Visite supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur lors de la suppression : " + e.getMessage());
        }
    }

}
