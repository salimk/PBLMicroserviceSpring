package com.rdvmedical.serviceguser.domain.dto.docteur;

import com.rdvmedical.serviceguser.domain.entity.Docteur;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link Docteur}
 */
public class DocteurCreateUpdateDto implements Serializable {
    @Email(message = "Format d'email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private final String email;
    @Size(min = 6, max = 20)
    @NotBlank
    private final String password;
    @Size(max = 50)
    @NotBlank
    private final String nom;
    @Size(max = 50)
    @NotBlank
    private final String prenom;
    @Pattern(regexp = "^[0-9 +()-]{6,20}$")
    private final String telephone;
    private final Set<Long> roleIds;
    @NotBlank
    private final String specialite;
    private final String inpe;

    public DocteurCreateUpdateDto(String email, String password, String nom, String prenom, String telephone, Set<Long> roleIds, String specialite, String inpe) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roleIds = roleIds;
        this.specialite = specialite;
        this.inpe = inpe;
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

    public String getSpecialite() {
        return specialite;
    }

    public String getInpe() {
        return inpe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocteurCreateUpdateDto entity = (DocteurCreateUpdateDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roleIds, entity.roleIds) &&
                Objects.equals(this.specialite, entity.specialite) &&
                Objects.equals(this.inpe, entity.inpe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nom, prenom, telephone, roleIds, specialite, inpe);
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
                "specialite = " + specialite + ", " +
                "inpe = " + inpe + ")";
    }
}