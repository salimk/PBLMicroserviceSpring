package com.rdvmedical.serviceguser.domain.dto.patient;

import com.rdvmedical.serviceguser.domain.dto.role.RoleDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.rdvmedical.serviceguser.domain.entity.Patient}
 */
public class PatientReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto> roles;
    private final String numeroSecuriteSocial;
    private final LocalDate dateNaissance;
    private final String sexe;

    public PatientReadDto(Long id, String email, String nom, String prenom, String telephone, Set<RoleDto> roles, String numeroSecuriteSocial, LocalDate dateNaissance, String sexe) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
        this.numeroSecuriteSocial = numeroSecuriteSocial;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public String getNumeroSecuriteSocial() {
        return numeroSecuriteSocial;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientReadDto entity = (PatientReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.numeroSecuriteSocial, entity.numeroSecuriteSocial) &&
                Objects.equals(this.dateNaissance, entity.dateNaissance) &&
                Objects.equals(this.sexe, entity.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nom, prenom, telephone, roles, numeroSecuriteSocial, dateNaissance, sexe);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roles = " + roles + ", " +
                "numeroSecuriteSocial = " + numeroSecuriteSocial + ", " +
                "dateNaissance = " + dateNaissance + ", " +
                "sexe = " + sexe + ")";
    }
}