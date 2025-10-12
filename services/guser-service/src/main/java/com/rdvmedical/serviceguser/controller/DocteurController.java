package com.rdvmedical.serviceguser.controller;

import com.rdvmedical.serviceguser.domain.dto.docteur.DocteurCreateUpdateDto;
import com.rdvmedical.serviceguser.domain.dto.docteur.DocteurReadDto;
import com.rdvmedical.serviceguser.domain.entity.Docteur;
import com.rdvmedical.serviceguser.mapper.DocteurMapper;
import com.rdvmedical.serviceguser.service.impl.ServiceDocteurImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/docteurs")
public class DocteurController {
    private final ServiceDocteurImpl serviceDocteur;
    private final DocteurMapper mapperdocteur;

    @Autowired
    public DocteurController(ServiceDocteurImpl serviceDocteur, DocteurMapper mapperdocteur) {
        this.serviceDocteur = serviceDocteur;
        this.mapperdocteur = mapperdocteur;
    }
    // READ ALL - GET /api/docteurs
    @GetMapping
    public ResponseEntity<List<DocteurReadDto>> getAllDocteurs() {
        return ResponseEntity.ok(
                serviceDocteur.getAllDocteurs().stream()
                        .map(mapperdocteur::toReadDto)
                        .toList()
        );
    }

    // CREATE - POST /api/docteurs
    @PostMapping
    public ResponseEntity<DocteurReadDto> createDocteur(
            @Valid @RequestBody DocteurCreateUpdateDto createDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Docteur docteur = mapperdocteur.toEntity(createDto);
        Docteur savedDocteur = serviceDocteur.createDocteur(docteur, roleIds);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapperdocteur.toReadDto(savedDocteur));
    }


    // READ ONE - GET /api/docteurs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DocteurReadDto> getDocteurById(@PathVariable Long id) {
        Docteur docteur = serviceDocteur.getDocteurById(id);
        return ResponseEntity.ok(mapperdocteur.toReadDto(docteur));
    }

    // UPDATE - PUT /api/docteurs/{id}
    @PutMapping("/{id}")
    public ResponseEntity<DocteurReadDto> updateDocteur(
            @PathVariable Long id,
            @Valid @RequestBody DocteurCreateUpdateDto updateDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Docteur docteur = mapperdocteur.toEntity(updateDto);
        docteur.setId(id);
        Docteur updatedDocteur = serviceDocteur.updateDocteur(docteur, roleIds);
        return ResponseEntity.ok(mapperdocteur.toReadDto(updatedDocteur));
    }

    // PARTIAL UPDATE - PATCH /api/docteurs/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<DocteurReadDto> partialUpdateDocteur(
            @PathVariable Long id,
            @RequestBody DocteurCreateUpdateDto updateDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Docteur existingDocteur = serviceDocteur.getDocteurById(id);
        mapperdocteur.partialUpdate(updateDto, existingDocteur);
        Docteur updatedDocteur = serviceDocteur.updateDocteur(existingDocteur, roleIds);
        return ResponseEntity.ok(mapperdocteur.toReadDto(updatedDocteur));
    }

    // DELETE - DELETE /api/docteurs/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocteur(@PathVariable Long id) {
        serviceDocteur.deleteDocteur(id);
        return ResponseEntity.noContent().build();
    }
}
