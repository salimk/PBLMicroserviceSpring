package com.rdvmedical.serviceguser.domain.dto;

import com.rdvmedical.serviceguser.domain.entity.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Role}
 */
public class RoleDto implements Serializable {
    @NotNull
    @Size
    private final String nom;

    public RoleDto(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto entity = (RoleDto) o;
        return Objects.equals(this.nom, entity.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nom = " + nom + ")";
    }
}