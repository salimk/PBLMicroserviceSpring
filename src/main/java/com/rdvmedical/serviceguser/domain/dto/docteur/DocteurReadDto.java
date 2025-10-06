package com.rdvmedical.serviceguser.domain.dto.docteur;

import com.rdvmedical.serviceguser.domain.dto.role.RoleDto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.rdvmedical.serviceguser.domain.entity.Docteur}
 */
public class DocteurReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final Set<RoleDto> roles;
    private final String specialite;
    private final String inpe;

    public DocteurReadDto(Long id, String email, String nom, String prenom, String telephone, Set<RoleDto> roles, String specialite, String inpe) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.roles = roles;
        this.specialite = specialite;
        this.inpe = inpe;
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
        DocteurReadDto entity = (DocteurReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.specialite, entity.specialite) &&
                Objects.equals(this.inpe, entity.inpe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nom, prenom, telephone, roles, specialite, inpe);
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
                "specialite = " + specialite + ", " +
                "inpe = " + inpe + ")";
    }
}