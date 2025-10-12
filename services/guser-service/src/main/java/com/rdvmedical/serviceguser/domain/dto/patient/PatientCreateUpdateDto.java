package com.rdvmedical.serviceguser.domain.dto.patient;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.rdvmedical.serviceguser.domain.entity.Patient}
 */
public class PatientCreateUpdateDto implements Serializable {
    @Email
    @NotBlank
    private final String email;
    @NotBlank
    @Size(min = 6, max = 20)
    private final String password;
    @Size(max = 50)
    @NotBlank
    private final String nom;
    @Size(max = 50)
    @NotBlank
    private final String prenom;
    @Pattern(regexp = "^[0-9 +()-]{6,20}$")
    private final String telephone;
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private final Set<Long> roleIds;
    @NotBlank
    private final String numeroSecuriteSocial;
    private final LocalDate dateNaissance;
    @NotBlank
    @Pattern(regexp="^[MF]$")
    @Size(min=1, max=1)
    private final String sexe;

    public PatientCreateUpdateDto(String email, String password, String nom, String prenom, String telephone, Set<Long> roleIds, String numeroSecuriteSocial, LocalDate dateNaissance, String sexe) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roleIds = roleIds;
        this.numeroSecuriteSocial = numeroSecuriteSocial;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public Set<Long> getRoleIds() {
        return roleIds;
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
        PatientCreateUpdateDto entity = (PatientCreateUpdateDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roleIds, entity.roleIds) &&
                Objects.equals(this.numeroSecuriteSocial, entity.numeroSecuriteSocial) &&
                Objects.equals(this.dateNaissance, entity.dateNaissance) &&
                Objects.equals(this.sexe, entity.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nom, prenom, telephone, roleIds, numeroSecuriteSocial, dateNaissance, sexe);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "telephone = " + telephone + ", " +
                "roleIds = " + roleIds + ", " +
                "numeroSecuriteSocial = " + numeroSecuriteSocial + ", " +
                "dateNaissance = " + dateNaissance + ", " +
                "sexe = " + sexe + ")";
    }
}