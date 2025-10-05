package com.rdvmedical.serviceguser.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DOCTEUR")
public class Docteur extends User {
    private String specialite;
    @Column(nullable = false, unique = true)
    private String inpe;

    public Docteur(String specialite, String inpe) {
        this.specialite = specialite;
        this.inpe = inpe;
    }

    public Docteur() {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getInpe() {
        return inpe;
    }

    public void setInpe(String inpe) {
        this.inpe = inpe;
    }
}
