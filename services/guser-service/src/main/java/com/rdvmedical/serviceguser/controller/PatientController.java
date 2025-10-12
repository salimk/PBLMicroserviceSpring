package com.rdvmedical.serviceguser.controller;

import com.rdvmedical.serviceguser.domain.dto.patient.PatientCreateUpdateDto;
import com.rdvmedical.serviceguser.domain.dto.patient.PatientReadDto;
import com.rdvmedical.serviceguser.domain.entity.Patient;
import com.rdvmedical.serviceguser.mapper.PatientMapper;
import com.rdvmedical.serviceguser.service.impl.ServicePatientImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final ServicePatientImpl servicePatient;
    private final PatientMapper mapperpatient;

    @Autowired
    public PatientController(ServicePatientImpl servicePatient, PatientMapper mapperpatient) {
        this.servicePatient = servicePatient;
        this.mapperpatient = mapperpatient;
    }
    // READ ALL - GET /api/patients
    @GetMapping
    public ResponseEntity<List<PatientReadDto>> getAllPatients() {
        return ResponseEntity.ok(
                servicePatient.getAllPatients().stream()
                        .map(mapperpatient::toReadDto)
                        .toList()
        );
    }

    // CREATE - POST /api/patients
    @PostMapping
    public ResponseEntity<PatientReadDto> createPatient(
            @Valid @RequestBody PatientCreateUpdateDto createDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Patient patient = mapperpatient.toEntity(createDto);
        Patient savedPatient = servicePatient.createPatient(patient, roleIds);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapperpatient.toReadDto(savedPatient));
    }


    // READ ONE - GET /api/patients/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PatientReadDto> getPatientById(@PathVariable Long id) {
        Patient patient = servicePatient.getPatientById(id);
        return ResponseEntity.ok(mapperpatient.toReadDto(patient));
    }

    // UPDATE - PUT /api/patients/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PatientReadDto> updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientCreateUpdateDto updateDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Patient patient = mapperpatient.toEntity(updateDto);
        patient.setId(id);
        Patient updatedPatient = servicePatient.updatePatient(patient, roleIds);
        return ResponseEntity.ok(mapperpatient.toReadDto(updatedPatient));
    }

    // PARTIAL UPDATE - PATCH /api/patients/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<PatientReadDto> partialUpdatePatient(
            @PathVariable Long id,
            @RequestBody PatientCreateUpdateDto updateDto,
            @RequestParam(required = false) Set<Long> roleIds) {
        Patient existingPatient = servicePatient.getPatientById(id);
        mapperpatient.partialUpdate(updateDto, existingPatient);
        Patient updatedPatient = servicePatient.updatePatient(existingPatient, roleIds);
        return ResponseEntity.ok(mapperpatient.toReadDto(updatedPatient));
    }

    // DELETE - DELETE /api/patients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        servicePatient.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
