package com.rdvmedical.serviceguser.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.hibernate.Length;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {
    @Column(unique = true)
    private String numeroSecuriteSocial;
    private LocalDate dateNaissance;
    @Column(nullable = false, length = 1)
    private String sexe;

    public Patient(String numeroSecuriteSocial, LocalDate dateNaissance, String sexe) {
        this.numeroSecuriteSocial = numeroSecuriteSocial;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
    }

    public Patient() {
    }

    public String getNumeroSecuriteSocial() {
        return numeroSecuriteSocial;
    }

    public void setNumeroSecuriteSocial(String numeroSecuriteSocial) {
        this.numeroSecuriteSocial = numeroSecuriteSocial;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
