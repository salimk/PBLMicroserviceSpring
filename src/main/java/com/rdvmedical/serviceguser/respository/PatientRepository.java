package com.rdvmedical.serviceguser.respository;

import com.rdvmedical.serviceguser.domain.entity.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientByNumeroSecuriteSocial(String numeroSecuriteSocial);
    Optional<Patient> findByEmail(String email);

    List<Patient> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseAndDateNaissanceAfter(String nom, String prenom, LocalDate dateNaissanceAfter);
}